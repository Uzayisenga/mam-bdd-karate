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
                                # Added -s (silent) to remove progress, keep -v for verbose headers for debugging if needed
                                curl -v -H "Authorization: Bearer ${ZEPHYR_TOKEN}" \\
                                     -H "Content-Type: application/json" \\
                                     -X GET "https://eu.api.zephyrscale.smartbear.com/v2/testcases?projectKey=SCRUM&status=Approved" \\
                                     -o src/test/resources/features/zephyr_testcases_raw.json

                                if [ ! -f src/test/resources/features/zephyr_testcases_raw.json ] || [ ! -s src/test/resources/features/zephyr_testcases_raw.json ]; then
                                    echo "Error: Failed to download or downloaded an empty zephyr_testcases_raw.json. Check API token and network."
                                    exit 1
                                fi

                                echo "Parsing downloaded JSON and extracting Gherkin..."

                                # Loop through each test case from the raw JSON and download its Gherkin
                                # Using 'read -r' for safer reading of lines
                                cat src/test/resources/features/zephyr_testcases_raw.json | jq -c '.values[]' | while IFS= read -r testcase_json; do
                                    key=$(printf "%s" "${testcase_json}" | jq -r '.key // empty')
                                    # Replace spaces with underscores for the filename
                                    name=$(printf "%s" "${testcase_json}" | jq -r '.name // empty' | sed 's/ /_/g')

                                    # Use // empty to ensure 'null' becomes an empty string, then check for emptiness
                                    testscript_url=$(printf "%s" "${testcase_json}" | jq -r '.testScript.self // empty')

                                    # Corrected comparison operator: '=' instead of '==' for portability
                                    if [ -z "${testscript_url}" ]; then # Check if the variable is empty (which 'null' from jq -r would be)
                                        echo "Warning: Test case ${key} - ${name} has no testScript URL or it's empty. Skipping Gherkin download."
                                        continue # Skip to the next test case
                                    fi

                                    echo "Downloading Gherkin for ${key} - ${name} from: ${testscript_url}"
                                    # Added -s (silent) to curl, as -v is only needed for initial debug
                                    gherkin_response=$(curl -s -H "Authorization: Bearer ${ZEPHYR_TOKEN}" -H "Content-Type: application/json" -X GET "${testscript_url}")

                                    # Extract the 'text' field using printf for safer piping to jq
                                    gherkin_text=$(printf "%s" "${gherkin_response}" | jq -r '.text // empty')

                                    if [ -n "${gherkin_text}" ]; then
                                        # Write the Gherkin text to a .feature file
                                        echo "${gherkin_text}" > "src/test/resources/features/${key}_${name}.feature"
                                        echo "Created feature file: ${key}_${name}.feature"
                                    else
                                        echo "Warning: No Gherkin text found for test case ${key} - ${name} (from ${testscript_url}). Feature file will be empty or not created."
                                    fi
                                done

                                # Count the actual feature files created (excluding the raw JSON)
                                # Added '2>/dev/null' to suppress 'No such file or directory' errors if no .feature files exist
                                num_feature_files=$(ls -1 src/test/resources/features/*.feature 2>/dev/null | wc -l)
                                if [ "${num_feature_files}" -eq 0 ]; then
                                    echo "Error: No feature files were successfully extracted. This build will fail as no tests can run."
                                    exit 1 # Fail the build explicitly if no feature files are generated
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
                                format: 'Cucumber',
                                filePath: 'target/karate-reports',
                                autoCreateTestCases: false,
                                customTestCycle: [
                                    name: "Automated Cycle - ${new Date().format("yyyy-MM-dd HH:mm")}",
                                    description: "Automated run for approved test cases",
                                    jiraProjectVersion: '10001',
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