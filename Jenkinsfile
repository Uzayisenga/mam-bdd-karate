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

        stage('Download Zephyr Feature Files') {
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

                                    # --- START DEBUGGING ADDITION ---
                                    echo "DEBUG: Raw gherkin_text for ${key} (from Zephyr):"
                                    echo "${gherkin_text}"
                                    echo "--- END DEBUG Raw gherkin_text ---"
                                    # --- END DEBUGGING ADDITION ---

                                    if [ -n "${gherkin_text}" ]; then
                                        # Construct the full Gherkin content
                                        full_gherkin_content="Feature: Zephyr Scale Test Automation
                                        @${key}
                                        Scenario: ${name_for_scenario}
                                        ${gherkin_text}"
                                        # --- START DEBUGGING ADDITION ---
                                        echo "DEBUG: Full Gherkin content being written to file for ${key}:"
                                        echo "${full_gherkin_content}"
                                        echo "--- END DEBUG Full Gherkin content ---"
                                        # --- END DEBUGGING ADDITION ---

                                        # Write the Gherkin text to a .feature file
                                        echo "${full_gherkin_content}" > "src/test/resources/features/${key}_${name_for_file}.feature"
                                        echo "Created feature file: src/test/resources/features/${key}_${name_for_file}.feature"
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

        stage('Build and Run Karate Tests') {
            steps {
                script {
                    sh 'mvn clean install -DskipTests' // Clean and build project first, skip tests here
                    sh 'mvn test -Dtest=KarateRunnerTest' // Then run specific tests
                }
            }
        }

        // Remaining Upload stages (keep the JAR one active, others commented for now)
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
                            echo "❌ Karate JSON report not found! No JSON to upload."
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