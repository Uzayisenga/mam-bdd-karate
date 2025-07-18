pipeline {
    agent any

    tools {
        maven 'Maven 3.9.4'  // Adjust if different
        jdk 'jdk-17'         // Adjust based on your setup
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Uzayisenga/mam-bdd-karate.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Run Tests') {
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
            junit 'target/surefire-reports/*.xml'
        }
    }

    stage('Upload to Zephyr') {
                steps {
                    // This is the correct way to use credentials in a declarative pipeline.
                    // The ID here MUST match the ID of the Secret text credential in Jenkins.
                    withCredentials([string(credentialsId: 'fa2cb66f-0fdc-43cf-8020-fd2d5ebf470c', variable: 'ZEPHYR_TOKEN')]) {
                        // Inside this block, ZEPHYR_TOKEN is available as an environment variable
                        bat 'upload-to-zephyr.bat'
                    }
                }
}
