pipeline {
    agent any

    tools {
        maven 'M3'
        jdk 'jdk17'
    }

    environment {
        FEATURES_DIR = 'src/test/resources/features'
    }

    stages {
        stage('Clean & Checkout') {
            steps {
                deleteDir()
                git 'https://github.com/Uzayisenga/mam-bdd-karate.git'
            }
        }

        stage('Download Zephyr Feature Files (Direct Curl)') {
            steps {
                script {
                    withEnv(["PATH+MAVEN=${tool 'Maven'}/bin:${tool 'JDK'}/bin"]) {
                        withCredentials([string(credentialsId: '01041c05-e42f-4e53-9afb-17332c383af9', variable: 'ZEPHYR_TOKEN')]) {
                            sh '''
                                mkdir -p src/test/resources/features
                                echo "Attempting to download feature files using curl..."

                                # First API call: Get the list of test cases
                                curl -v -H "Authorization: Bearer ${ZEPHYR_TOKEN}" \\
                                     -H "Content-Type: application/json" \\
                                     -X GET "https://eu.api.zephyrscale.smartbear.com/v2/testcases?projectKey=SCRUM&status=Approved" \\
                                     -o src/test/resources/features/zephyr_testcases_raw.json

                                if [ ! -f src/test/resources/features/zephyr_testcases_raw.json ] || [ ! -s src/test/resources/features/zephyr_testcases_raw.json ]; then
                                    echo "Error: Failed to download or downloaded an empty zephyr_testcases_raw.json. Check API token and network."
                                    exit 1
                                fi

                                echo "Parsing downloaded JSON and extracting Gherkin..."

                                cat src/test/resources/features/zephyr_testcases_raw.json | jq -c '.values[]' | while IFS= read -r testcase_json; do
                                    key=$(printf "%s" "${testcase_json}" | jq -r '.key // empty')
                                    # Replace spaces with underscores for the filename, but keep original for Scenario title
                                    name_for_file=$(printf "%s" "${testcase_json}" | jq -r '.name // empty' | sed 's/ /_/g')
                                    name_for_scenario=$(printf "%s" "${testcase_json}" | jq -r '.name // empty')

                                    testscript_url=$(printf "%s" "${testcase_json}" | jq -r '.testScript.self // empty')

                                    if [ -z "${testscript_url}" ]; then
                                        echo "Warning: Test case ${key} - ${name_for_scenario} has no testScript URL or it's empty. Skipping Gherkin download."
                                        continue
                                    fi

                                    echo "Downloading Gherkin for ${key} - ${name_for_scenario} from: ${testscript_url}"
                                    gherkin_response=$(curl -s -H "Authorization: Bearer ${ZEPHYR_TOKEN}" -H "Content-Type: application/json" -X GET "${testscript_url}")
                                    gherkin_text=$(printf "%s" "${gherkin_response}" | jq -r '.text // empty')

                                    if [ -n "${gherkin_text}" ]; then
                                        # Construct the full Gherkin content
                                        # We'll use a generic Feature name for now, you can make this dynamic if needed
                                        # The 'key' can be added as a tag for better integration with Karate/Cucumber
                                        full_gherkin_content="Feature: Zephyr Scale Test Automation

        @${key}
        Scenario: ${name_for_scenario}
        ${gherkin_text}"
                                        # Write the Gherkin text to a .feature file
                                        echo "${full_gherkin_content}" > "src/test/resources/features/${key}_${name_for_file}.feature"
                                        echo "Created feature file: ${key}_${name_for_file}.feature"
                                    else
                                        echo "Warning: No Gherkin text found for test case ${key} - ${name_for_scenario}. Feature file will be empty or not created."
                                    fi
                                done

                                num_feature_files=$(ls -1 src/test/resources/features/*.feature 2>/dev/null | wc -l)
                                if [ "${num_feature_files}" -eq 0 ]; then
                                    echo "Error: No feature files were successfully extracted. This build will fail as no tests can run."
                                    exit 1
                                else
                                    echo "Successfully extracted ${num_feature_files} feature files."
                                fi
                            '''
                        }
                    }
                }
            }
        }


      stage('Clean Workspace (Maven)') {
                  steps {
                      sh 'mvn clean'
                  }
              }

              stage('Build and Run Karate Tests') {
                  steps {
                      sh 'mvn test'
                  }
              }


    stage('Run Karate Tests') {
                steps {
                    sh 'mvn test -Dtest=KarateRunnerTest'
                }
            }
            stage('Upload Karate Results to Zephyr Scale (JAR)') {
                environment {
                    ZEPHYR_TOKEN = credentials('01041c05-e42f-4e53-9afb-17332c383af9')
                }
                steps {
                    script {
                        sh '''
                            echo "📤 Uploading Karate JSON to Zephyr Scale using JAR..."

                            FILE=$(ls target/karate-reports/*.json | head -n 1)
                            if [ ! -f "$FILE" ]; then
                                echo "❌ Karate JSON report not found!"
                                exit 1
                            fi

                            echo "Found JSON file: $FILE"

                            # Create ZIP file using jar command (part of JDK)
                            ZIP_FILE="cucumber-results.zip"
                            echo "Creating ZIP file using jar command..."

                            # Create temporary directory structure for jar
                            mkdir -p temp_zip
                            cp "$FILE" temp_zip/

                            # Create ZIP using jar
                            cd temp_zip
                            jar -cfM "../$ZIP_FILE" "$(basename "$FILE")"
                            cd ..

                            # Clean up temp directory
                            rm -rf temp_zip

                            if [ ! -f "$ZIP_FILE" ]; then
                                echo "❌ Failed to create ZIP file with jar!"
                                exit 1
                            fi

                            echo "✅ Created ZIP file: $ZIP_FILE"

                            TIMESTAMP=$(date +"%Y-%m-%d_%H-%M")
                            CYCLE_NAME="Automated_Cycle_${TIMESTAMP}"
                            CYCLE_DESC="Automated%20run%20from%20Jenkins%20pipeline"

                            # Upload ZIP file to Zephyr Scale with autoCreateTestCases=true
                            echo "Uploading to Zephyr Scale..."
                            RESPONSE=$(curl -s -X POST "https://eu.api.zephyrscale.smartbear.com/v2/automations/executions/cucumber?projectKey=SCRUM&autoCreateTestCases=true&testCycleName=${CYCLE_NAME}&testCycleDescription=${CYCLE_DESC}&jiraProjectVersion=10001&folderId=root" \
                                -H "Authorization: Bearer ${ZEPHYR_TOKEN}" \
                                -F "file=@${ZIP_FILE}")

                            echo "API Response: $RESPONSE"

                            # Clean up ZIP file
                            rm -f "$ZIP_FILE"

                            # Check response for different types of success/error
                            if echo "$RESPONSE" | grep -q '"testExecutions"\\|"testExecutionKey"\\|"executions"'; then
                                echo "✅ Upload successful! Test executions created."
                                echo "Full response: $RESPONSE"
                            elif echo "$RESPONSE" | grep -q "Couldn\\'t find any mapped test cases"; then
                                echo "⚠️  Upload successful, but no test cases were mapped."
                                echo "This means your Karate scenarios don\\'t have @TestCaseKey tags or matching test cases don\\'t exist in Zephyr Scale."
                                echo "Solutions:"
                                echo "1. Add @TestCaseKey=SCRUM-T123 tags to your Karate scenarios"
                                echo "2. Create test cases in Zephyr Scale that match your scenario names"
                                echo "3. Enable autoCreateTestCases=true (already enabled)"
                                echo "Full response: $RESPONSE"
                            elif echo "$RESPONSE" | grep -q "errorCode"; then
                                echo "❌ Upload failed with error: $RESPONSE"
                                exit 1
                            else
                                echo "✅ Upload completed. Response: $RESPONSE"
                            fi
                        '''
                    }
                }
            }
//             stage('Upload Karate Results to Zephyr Scale (Install ZIP)') {
//                 environment {
//                     ZEPHYR_TOKEN = credentials('01041c05-e42f-4e53-9afb-17332c383af9')
//                 }
//                 steps {
//                     script {
//                         sh '''
//                             echo "📤 Installing zip and uploading Karate JSON to Zephyr Scale..."
//
//                             # Install zip if not available (works on Debian/Ubuntu-based images)
//                             if ! command -v zip &> /dev/null; then
//                                 echo "Installing zip utility..."
//                                 apt-get update -qq && apt-get install -y zip
//                             fi
//
//                             FILE=$(ls target/karate-reports/*.json | head -n 1)
//                             if [ ! -f "$FILE" ]; then
//                                 echo "❌ Karate JSON report not found!"
//                                 exit 1
//                             fi
//
//                             echo "Found JSON file: $FILE"
//
//                             # Create ZIP file containing the JSON
//                             ZIP_FILE="cucumber-results.zip"
//                             zip -j "$ZIP_FILE" "$FILE"
//
//                             if [ ! -f "$ZIP_FILE" ]; then
//                                 echo "❌ Failed to create ZIP file!"
//                                 exit 1
//                             fi
//
//                             echo "Created ZIP file: $ZIP_FILE"
//
//                             TIMESTAMP=$(date +"%Y-%m-%d_%H-%M")
//                             CYCLE_NAME="Automated_Cycle_${TIMESTAMP}"
//                             CYCLE_DESC="Automated%20run%20from%20Jenkins%20pipeline"
//
//                             # Upload ZIP file to Zephyr Scale
//                             RESPONSE=$(curl -s -X POST "https://eu.api.zephyrscale.smartbear.com/v2/automations/executions/cucumber?projectKey=SCRUM&autoCreateTestCases=false&testCycleName=${CYCLE_NAME}&testCycleDescription=${CYCLE_DESC}&jiraProjectVersion=10001&folderId=root" \\
//                                 -H "Authorization: Bearer ${ZEPHYR_TOKEN}" \\
//                                 -F "file=@${ZIP_FILE}")
//
//                             echo "Response: $RESPONSE"
//
//                             # Clean up ZIP file
//                             rm -f "$ZIP_FILE"
//
//                             # Check if response contains error
//                             if echo "$RESPONSE" | grep -q "errorCode"; then
//                                 echo "❌ Upload failed: $RESPONSE"
//                                 exit 1
//                             else
//                                 echo "✅ Upload successful!"
//                                 echo "$RESPONSE"
//                             fi
//                         '''
//                     }
//                 }
//             }
            stage('Upload Karate Results to Zephyr Scale (Direct Curl)') {
                environment {
                    ZEPHYR_TOKEN = credentials('01041c05-e42f-4e53-9afb-17332c383af9')
                }
                steps {
                    script {
                        sh '''
                            echo "📤 Uploading Karate JSON to Zephyr Scale..."

                            FILE=$(ls target/karate-reports/*.json | head -n 1)
                            if [ ! -f "$FILE" ]; then
                                echo "❌ Karate JSON report not found!"
                                exit 1
                            fi

                            echo "Found JSON file: $FILE"

                            # Method 1: Try creating ZIP with jar command (part of Java)
                            ZIP_FILE="cucumber-results.zip"
                            echo "Attempting to create ZIP using jar command..."

                            if jar -cfM "$ZIP_FILE" -C "$(dirname "$FILE")" "$(basename "$FILE")" 2>/dev/null; then
                                echo "✅ Created ZIP using jar: $ZIP_FILE"
                            elif command -v python >/dev/null 2>&1; then
                                echo "Trying with python (not python3)..."
                                python -c "
            import zipfile
            import sys
            import os

            json_file = '$FILE'
            zip_file = '$ZIP_FILE'

            if os.path.exists(json_file):
                with zipfile.ZipFile(zip_file, 'w') as zf:
                    zf.write(json_file, os.path.basename(json_file))
                print('Created ZIP: ' + zip_file)
                sys.exit(0)
            else:
                print('JSON file not found: ' + json_file)
                sys.exit(1)
            "
                            else
                                echo "⚠️  No ZIP creation method available. Trying to upload raw JSON..."
                                echo "Some Zephyr Scale instances may accept raw JSON files."
                                ZIP_FILE="$FILE"
                            fi

                            if [ ! -f "$ZIP_FILE" ]; then
                                echo "❌ Failed to create any file for upload!"
                                exit 1
                            fi

                            echo "Using file for upload: $ZIP_FILE"

                            TIMESTAMP=$(date +"%Y-%m-%d_%H-%M")
                            CYCLE_NAME="Automated_Cycle_${TIMESTAMP}"
                            CYCLE_DESC="Automated%20run%20from%20Jenkins%20pipeline"

                            # Upload file to Zephyr Scale
                            echo "Uploading to Zephyr Scale..."
                            RESPONSE=$(curl -s -X POST "https://eu.api.zephyrscale.smartbear.com/v2/automations/executions/cucumber?projectKey=SCRUM&autoCreateTestCases=false&testCycleName=${CYCLE_NAME}&testCycleDescription=${CYCLE_DESC}&jiraProjectVersion=10001&folderId=root" \
                                -H "Authorization: Bearer ${ZEPHYR_TOKEN}" \
                                -F "file=@${ZIP_FILE}")

                            echo "Response: $RESPONSE"

                            # Clean up created ZIP file (but not original JSON)
                            if [ "$ZIP_FILE" != "$FILE" ]; then
                                rm -f "$ZIP_FILE" 2>/dev/null || true
                            fi

                            # Check if response contains error
                            if echo "$RESPONSE" | grep -q "errorCode"; then
                                echo "❌ Upload failed: $RESPONSE"
                                # Don't exit 1 here - let's see what the actual error is
                                echo "Full response for debugging: $RESPONSE"
                            else
                                echo "✅ Upload successful!"
                                echo "$RESPONSE"
                            fi
                        '''
                    }
                }
            }

//             // Alternative method using mixed approach (if the above doesn't work)
//             stage('Upload Karate Results to Zephyr Scale (Alternative)') {
//                 environment {
//                     ZEPHYR_TOKEN = credentials('01041c05-e42f-4e53-9afb-17332c383af9')
//                 }
//                 steps {
//                     script {
//                         sh '''
//                             echo "📤 Uploading Karate JSON to Zephyr Scale..."
//
//                             FILE=$(ls target/karate-reports/*.json | head -n 1)
//                             if [ ! -f "$FILE" ]; then
//                                 echo "❌ Karate JSON report not found!"
//                                 exit 1
//                             fi
//
//                             TIMESTAMP=$(date +"%Y-%m-%d_%H-%M")
//
//                             # Store response for debugging
//                             RESPONSE=$(curl -s -X POST "https://eu.api.zephyrscale.smartbear.com/v2/automations/executions/cucumber" \
//                                 -H "Authorization: Bearer ${ZEPHYR_TOKEN}" \
//                                 -H "Content-Type: multipart/form-data" \
//                                 -F "file=@${FILE}" \
//                                 -F "projectKey=SCRUM" \
//                                 -F "autoCreateTestCases=false" \
//                                 -F "testCycleName=Automated_Cycle_${TIMESTAMP}" \
//                                 -F "testCycleDescription=Automated run from Jenkins pipeline" \
//                                 -F "jiraProjectVersion=10001" \
//                                 -F "folderId=root")
//
//                             echo "Response: $RESPONSE"
//
//                             # Check if response contains error
//                             if echo "$RESPONSE" | grep -q "errorCode"; then
//                                 echo "❌ Upload failed: $RESPONSE"
//                                 exit 1
//                             else
//                                 echo "✅ Upload successful: $RESPONSE"
//                             fi
//                         '''
//                     }
//                 }
//             }


        stage('Upload Karate Results to Zephyr Scale') { // Simplified stage name
          environment {
            ZEPHYR_TOKEN = credentials('01041c05-e42f-4e53-9afb-17332c383af9')
          }
          steps {
            script {
              sh '''
                echo "📤 Uploading Karate JSON to Zephyr Scale..."

                FILE=$(ls target/karate-reports/*.json | head -n 1)
                if [ ! -f "$FILE" ]; then
                  echo "❌ Karate JSON report not found!"
                  exit 1
                fi

                TIMESTAMP=$(date +"%Y-%m-%d_%H-%M")

                curl -s -X POST "https://eu.api.zephyrscale.smartbear.com/v2/automations/executions/cucumber" \\
                  -H "Authorization: Bearer ${ZEPHYR_TOKEN}" \\
                  -F "file=@${FILE};type=application/json" \\
                  -F "projectKey=SCRUM" \\
                  -F "autoCreateTestCases=false" \\
                  -F "testCycleName=Automated_Cycle_${TIMESTAMP}" \\
                  -F "testCycleDescription=Automated run from Jenkins pipeline" \\
                  -F "jiraProjectVersion=10001" \\
                  -F "folderId=root"
              '''
            }
          }
        }

}

        post {
            always {
                junit testResults: 'target/surefire-reports/**/*.xml', allowEmptyResults: true
                cucumber jsonReportDirectory: 'target/karate-reports', fileIncludePattern: '**/*.json', mergeFeaturesById: true, skipEmptyJSONFiles: true
                archiveArtifacts artifacts: 'target/karate-reports/*.html', allowEmptyArchive: true
                archiveArtifacts artifacts: 'target/karate-reports/*.json', allowEmptyArchive: true
            }
        }
    }