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

        stage('Download Zephyr Feature Files (Direct Curl)') { // New, clear name
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

        stage('Clean Workspace (Maven)') { // Renamed for clarity
            steps {
                sh 'mvn clean'
            }
        }

        stage('Build and Run Karate Tests') { // Combined and renamed stage
            steps {
                sh 'mvn test' # This will run both DownloadRunner and KarateRunnerTest
            }
        }

        // ... ensure your post-actions are still there, especially for Cucumber reports
        // and the Zephyr Scale upload step (which can now use the 'Cucumber' format)
    }

    post {
        always {
            junit testResults: 'target/surefire-reports/**/*.xml', allowEmptyResults: true
            cucumber jsonReportDirectory: 'target/karate-reports', fileIncludePattern: '**/*.json', mergeFeaturesById: true, skipEmptyJSONFiles: true

            script {
                try {
                    if (fileExists('target/karate-reports') &&
                        sh(script: 'ls target/karate-reports/*.json 2>/dev/null | wc -l', returnStdout: true).trim() != '0') {

                        // This step should now use the Cucumber format since Karate outputs Cucumber JSON
                        // And you'll need the API Key (JWT) here too.
                        withCredentials([string(credentialsId: '01041c05-e42f-4e53-9afb-17332c383af9', variable: 'ZEPHYR_TOKEN')]) {
                            publishTestResults serverAddress: 'https://mileand.atlassian.net', // Or instance: 'MyZephyrCloud' if you get it working
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