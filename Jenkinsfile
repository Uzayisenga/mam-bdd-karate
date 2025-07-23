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
        stage('Download Feature Files'){
                    steps {
                        downloadFeatureFiles serverAddress: 'http://localhost:2990/jira',
                            projectKey: 'WEB',
                            targetPath:'src/test/resources/features'
                    }
                }
                stage('Clean Work Space'){
                    steps {
                        sh 'mvn clean'
                    }
                }
                stage('Build') {
                    steps {
                        sh 'mvn test'
                    }
                }
            }
            post {
                always {
                    publishTestResults serverAddress: 'https://mileand.atlassian.net',
                    projectKey: 'SCRUM',
                    format: 'Cucumber',
                    filePath: 'target/karate-reports',
                    autoCreateTestCases: false,
                      customTestCycle: [
                        name: 'Jenkins Build',
                        description: 'Results from Jenkins Build',
                        jiraProjectVersion: '10001',
                        folderId: 'root',
                        customFields: '{"number":50,"single-choice":"option1","checkbox":true,"userpicker":"5f8b5cf2ddfdcb0b8d1028bb","single-line":"a text line","datepicker":"2020-01-25","decimal":10.55,"multi-choice":["choice1","choice3"],"multi-line":"first line<br />second line"}'
                      ]
                }
            }

        stage('Download Approved Features from Zephyr') {
            steps {
                withCredentials([string(credentialsId: 'zephyr-api-token', variable: 'ZEPHYR_TOKEN')]) {
                    sh '''
                        mkdir -p $FEATURES_DIR
                        curl -H "Authorization: Bearer $ZEPHYR_TOKEN" \
                             -H "Content-Type: application/json" \
                             -X GET "https://eu.api.zephyrscale.smartbear.com/v2/testcases?projectKey=SCRUM&status=Approved" \
                             -o approved-tests.json

                        # Extract Gherkin and write to feature files
                        jq -c '.values[]' approved-tests.json | while read test; do
                            key=$(echo "$test" | jq -r '.key')
                            name=$(echo "$test" | jq -r '.name' | sed 's/ /_/g')
                            gherkin=$(echo "$test" | jq -r '.testScript.text')
                            echo "$gherkin" > "$FEATURES_DIR/${key}_${name}.feature"
                        done
                    '''
                }
            }
        }

        stage('Run Karate Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Publish Karate Report') {
            steps {
                publishHTML(target: [
                    reportName: 'Karate Report',
                    reportDir: 'target/karate-reports',
                    reportFiles: 'karate-summary.html'
                ])
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

