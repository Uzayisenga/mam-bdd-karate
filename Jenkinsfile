pipeline {
    agent any

    tools {
        maven 'M3'
        jdk 'jdk17'
    }

    environment {
        ZEPHYR_TOKEN = credentials('zephyr-api-token')
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Uzayisenga/mam-bdd-karate.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install -DskipTests'
            }
        }

        stage('Run Karate Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Publish Karate Report') {
            steps {
                publishHTML(target: [
                    reportName : 'Karate Report',
                    reportDir  : 'target/karate-reports',
                    reportFiles: 'karate-summary.html',
                    keepAll    : true,
                    alwaysLinkToLastBuild: true
                ])
            }
        }

        stage('Upload to Zephyr Scale') {
            steps {
                script {
                    echo "Uploading test results to Zephyr Scale..."
                    bat 'upload-to-zephyr.bat'
                }
            }
        }
    }

    post {
        always {
            echo 'Archiving Karate HTML and JSON reports...'
            archiveArtifacts artifacts: 'target/karate-reports/*.html', allowEmptyArchive: true
            archiveArtifacts artifacts: 'target/karate-reports/*.json', allowEmptyArchive: true
        }
    }
}
