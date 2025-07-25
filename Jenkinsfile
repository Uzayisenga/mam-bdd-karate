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
                withCredentials([string(credentialsId: '01041c05-e42f-4e53-9afb-17332c383af9', variable: 'ZEPHYR_TOKEN')]) {
                    sh '''
                        mkdir -p "$FEATURES_DIR"
                        echo "Attempting to download feature files using curl..."
                        curl -v \
                             -H "Authorization: Bearer $ZEPHYR_TOKEN" \
                             -H "Content-Type: application/json" \
                             -X GET "https://eu.api.zephyrscale.smartbear.com/v2/testcases?projectKey=SCRUM&status=Approved" \
                             -o "$FEATURES_DIR/zephyr_testcases_raw.json"

                        if [ ! -f "$FEATURES_DIR/zephyr_testcases_raw.json" ]; then
                            echo "ERROR: Raw JSON file not downloaded by curl. Exiting."
                            exit 1
                        fi

                        echo "Parsing downloaded JSON and extracting Gherkin..."
                        # Ensure jq is installed on your Jenkins agent!
                        jq -c '.values[]' "$FEATURES_DIR/zephyr_testcases_raw.json" | while read test; do
                            key=$(echo "$test" | jq -r '.key')
                            name=$(echo "$test" | jq -r '.name' | sed 's/ /_/g')
                            gherkin=$(echo "$test" | jq -r '.testScript.text')
                            if [ -n "$gherkin" ]; then # Only create file if gherkin content exists
                                echo "$gherkin" > "$FEATURES_DIR/${key}_${name}.feature"
                                echo "Created feature file: ${key}_${name}.feature"
                            else
                                echo "Skipping ${key}_${name}.feature: No Gherkin content found."
                            fi
                        done

                        if [ $(ls -1 "$FEATURES_DIR"/*.feature 2>/dev/null | wc -l) -eq 0 ]; then
                            echo "WARNING: No .feature files were extracted. Check Zephyr Scale for Gherkin content or jq script."
                        else
                            echo "Successfully extracted $(ls -1 "$FEATURES_DIR"/*.feature | wc -l) feature files."
                        fi
                    '''
                }
            }
        }
        stage('Download Zephyr Feature Files') {
            steps {
                script {
                    env.ZEPHYR_BASE_URL = 'https://eu.api.zephyrscale.smartbear.com/v2'
                    env.ZEPHYR_PROJECT_KEY = 'SCRUM'
                    env.ZEPHYR_APPROVAL_STATUS = 'Approved'
                    def featureDir = "src/test/resources/features"

                    sh "mkdir -p ${featureDir}"

                    withCredentials([string(credentialsId: '01041c05-e42f-4e53-9afb-17332c383af9', variable: 'ZEPHYR_TOKEN')]) {
                        sh """
                            cd "${featureDir}"

                            echo "Attempting to download test case list from Zephyr Scale..."
                            curl -s -H "Authorization: Bearer \${ZEPHYR_TOKEN}" -H "Content-Type: application/json" -X GET "${env.ZEPHYR_BASE_URL}/testcases?projectKey=${env.ZEPHYR_PROJECT_KEY}&status=${env.ZEPHYR_APPROVAL_STATUS}" -o zephyr_testcases_raw.json

                            if [ ! -f zephyr_testcases_raw.json ] || [ ! -s zephyr_testcases_raw.json ]; then
                                echo "Error: zephyr_testcases_raw.json not found or empty after download."
                                exit 1
                            fi

                            echo "Parsing downloaded JSON and extracting Gherkin..."

                            # Loop through each test case from the raw JSON
                            jq -c '.values[]' zephyr_testcases_raw.json | while read testcase_json; do
                                key=\$(echo "\$testcase_json" | jq -r '.key')
                                name=\$(echo "\$testcase_json" | jq -r '.name' | sed 's/ /_/g')
                                testscript_url=\$(echo "\$testcase_json" | jq -r '.testScript.self')

                                if [ "\$testscript_url" == "null" ] || [ -z "\$testscript_url" ]; then
                                    echo "Warning: Test case \$key - \$name has no testScript URL. Skipping Gherkin download."
                                    continue
                                fi

                                echo "Downloading Gherkin for \$key - \$name from: \$testscript_url"
                                gherkin_response=\$(curl -s -H "Authorization: Bearer \${ZEPHYR_TOKEN}" -H "Content-Type: application/json" -X GET "\$testscript_url")

                                # Extract the 'text' field. Use // empty to handle null/missing 'text' gracefully.
                                gherkin_text=\$(echo "\$gherkin_response" | jq -r '.text // empty')

                                if [ -n "\$gherkin_text" ]; then
                                    echo "\$gherkin_text" > "${key}_${name}.feature"
                                    echo "Created feature file: ${key}_${name}.feature"
                                else
                                    echo "Warning: No Gherkin text found for test case \$key - \$name (from \$testscript_url). Feature file will be empty or not created."
                                    # Optionally, create an empty file as a placeholder if you want to track all Zephyr tests, even if Gherkin is missing
                                    # echo "" > "${key}_${name}.feature"
                                fi
                            done

                            # Clean up the raw JSON file after processing
                            rm zephyr_testcases_raw.json

                            num_features=\$(ls -1 *.feature 2>/dev/null | wc -l) # Redirect stderr to /dev/null for ls
                            if [ "\$num_features" -eq 0 ]; then
                                echo "Error: No feature files were successfully extracted from Zephyr Scale."
                                exit 1
                            else
                                echo "Successfully extracted \$num_features feature files from Zephyr Scale."
                            fi
                            # Loop through each test case from the raw JSON
                                                jq -c '.values[]' zephyr_testcases_raw.json | while read testcase_json; do
                                                    key=\$(echo "\$testcase_json" | jq -r '.key')
                                                    name=\$(echo "\$testcase_json" | jq -r '.name' | sed 's/ /_/g')
                                                    testscript_url=\$(echo "\$testcase_json" | jq -r '.testScript.self')

                                                    if [ "\$testscript_url" == "null" ] || [ -z "\$testscript_url" ]; then
                                                        echo "Warning: Test case \$key - \$name has no testScript URL. Skipping Gherkin download."
                                                        continue
                                                    fi

                                                    echo "Downloading Gherkin for \$key - \$name from: \$testscript_url"
                                                    gherkin_response=\$(curl -s -H "Authorization: Bearer \${ZEPHYR_TOKEN}" -H "Content-Type: application/json" -X GET "\$testscript_url")

                                                    # Extract the 'text' field. Use // empty to handle null/missing 'text' gracefully.
                                                    gherkin_text=\$(echo "\$gherkin_response" | jq -r '.text // empty')

                                                    if [ -n "\$gherkin_text" ]; then
                                                        echo "\$gherkin_text" > "${key}_${name}.feature"
                                                        echo "Created feature file: ${key}_${name}.feature"
                                                    else
                                                        echo "Warning: No Gherkin text found for test case \$key - \$name (from \$testscript_url). Feature file will be empty or not created."
                                                    fi
                                                done
                        """
                    }
                }
            }
        }

      stage('Clean Workspace (Maven)') { // Renamed for clarity
                  steps {
                      sh 'mvn clean'
                  }
              }

              stage('Build and Run Karate Tests') { // Combined and renamed stage
                  steps {
                      sh 'mvn test'
                  }
              }

          }





    post {
        always {
            junit testResults: 'target/surefire-reports/**/*.xml', allowEmptyResults: true
            cucumber jsonReportDirectory: 'target/karate-reports', fileIncludePattern: '**/*.json', mergeFeaturesById: true, skipEmptyJSONFiles: true

            script {
                try {
                    if (fileExists('target/karate-reports') &&
                        sh(script: 'ls target/karate-reports/*.json 2>/dev/null | wc -l', returnStdout: true).trim() != '0') {
                        withCredentials([string(credentialsId: '01041c05-e42f-4e53-9afb-17332c383af9', variable: 'ZEPHYR_TOKEN')]) {
                            publishTestResults serverAddress: 'https://mileand.atlassian.net',
                                projectKey: 'SCRUM',
                                format: 'Cucumber', // Use Cucumber format
                                filePath: 'target/karate-reports',
                                autoCreateTestCases: false,
                                customTestCycle: [
                                    name: "Automated Cycle - ${new Date().format("yyyy-MM-dd HH:mm")}",
                                    description: "Automated run for approved test cases",
                                    jiraProjectVersion: '10001', // Ensure this version exists in Jira
                                    folderId: 'root',
                                    customFields: '{}'
                                ]
                        }
                    } else {
                        echo '[Zephyr Upload SKIPPED] No Karate JSON reports found.'
                    }
                } catch (Exception e) {
                    echo "[Zephyr Upload ERROR] ${e.message}"
                }
            }

            archiveArtifacts artifacts: 'target/karate-reports/*.html', allowEmptyArchive: true
            archiveArtifacts artifacts: 'target/karate-reports/*.json', allowEmptyArchive: true
        }
    }
}