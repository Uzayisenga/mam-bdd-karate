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

            stage('Upload Karate Results to Zephyr Scale (Direct Curl)') {
                            steps {
                                script {
                                    withCredentials([string(credentialsId: '01041c05-e42f-4e53-9afb-17332c383af9', variable: 'ZEPHYR_TOKEN')]) {
                                        sh '''
                                            echo "Uploading Karate JSON to Zephyr Scale..."

                                            num_json_files=$(ls -1 target/karate-reports/*.json 2>/dev/null | wc -l)
                                            if [ "$num_json_files" -eq 0 ]; then
                                                echo "[Zephyr Upload SKIPPED] No Karate JSON reports found."
                                                exit 0
                                            fi

                                            for json_file in target/karate-reports/*.json; do
                                                curl -v -X POST 'https://eu.api.zephyrscale.smartbear.com/v2/automations/executions/cucumber' \\
                                                     -H "Authorization: Bearer ${ZEPHYR_TOKEN}" \\
                                                     # REMOVE THIS LINE: -H "Content-Type: multipart/form-data" \\
                                                     -F "file=@${json_file}" \\
                                                     -F "projectKey=SCRUM" \\
                                                     -F "autoCreateTestCases=false" \\
                                                     -F "testCycleName=Automated Cycle - $(date +'%Y-%m-%d %H:%M')" \\
                                                     -F "testCycleDescription=Automated run for approved test cases from Jenkins pipeline" \\
                                                     -F "jiraProjectVersion=10001" \\
                                                     -F "folderId=root"
                                            done
                                            echo "Upload complete."
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