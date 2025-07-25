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
        		                downloadFeatureFiles serverAddress: 'https://mileand.atlassian.net/projects/SCRUM?selectedItem=com.atlassian.plugins.atlassian-connect-plugin:com.kanoah.test-manager__main-project-page#!/v2/testCases',
        		                    projectKey: 'SCRUM',
        		                    targetPath:'src/test/resources/features'
        		            }
        		        }
        stage('Download Feature Files (Plugin)') {
            steps {
                withCredentials([string(credentialsId: '01041c05-e42f-4e53-9afb-17332c383af9', variable: 'ZEPHYR_TOKEN')]) {
                downloadFeatureFiles serverAddress: 'https://mileand.atlassian.net/projects/SCRUM?selectedItem=com.atlassian.plugins.atlassian-connect-plugin:com.kanoah.test-manager__main-project-page#!/v2/testCases',
                    projectKey: 'SCRUM',
                    targetPath: 'src/test/resources/features'
                    }
            }
        }

        stage('Clean Workspace') {
            steps {
                sh 'mvn clean'
            }
        }

        stage('Build Karate') {
            steps {
                sh 'mvn test'
                sh 'mvn clean test -Dkarate.env.baseUrl=https://eu.api.zephyrscale.smartbear.com/v2 -Dkarate.env.zephyrToken=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjb250ZXh0Ijp7ImJhc2VVcmwiOiJodHRwczovL21pbGVhbmQuYXRsYXNzaWFuLm5ldCIsInVzZXIiOnsiYWNjb3VudElkIjoiNzEyMDIwOjY5OTJlMTEyLTc4N2QtNDNiNy04MzlkLTFhNmZiNGE4MTYwOCIsInRva2VuSWQiOiIwMTA0MWMwNS1lNDJmLTRlNTMtOWFmYi0xNzMzMmMzODNhZjkifX0sImlzcyI6ImNvbS5rYW5vYWgudGVzdC1tYW5hZ2VyIiwic3ViIjoiMTM2NjU0OTItZjA0OS0zN2RkLWExMmEtNzFmZTdjOTM4MjM0IiwiZXhwIjoxNzg0NjIzNTI3LCJpYXQiOjE3NTMwODc1Mjd9.Xi8jWOdL54fTQRGGOFSBAZD_3S6a3s6bEXS_daDChhw'
            }
        }

        stage('Download Approved Features from Zephyr') {
            steps {
                withCredentials([string(credentialsId: '01041c05-e42f-4e53-9afb-17332c383af9', variable: 'ZEPHYR_TOKEN')]) {
                    sh '''
                        mkdir -p $FEATURES_DIR
                        curl -H "Authorization: Bearer $ZEPHYR_TOKEN" \
                             -H "Content-Type: application/json" \
                             -X GET "https://eu.api.zephyrscale.smartbear.com/v2/testcases?projectKey=SCRUM&status=Approved" \
                             -o approved-tests.json

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

                        publishTestResults serverAddress: 'https://mileand.atlassian.net/projects/SCRUM?selectedItem=com.atlassian.plugins.atlassian-connect-plugin:com.kanoah.test-manager__main-project-page#!/v2/testCycles?projectId=10000',
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
}
