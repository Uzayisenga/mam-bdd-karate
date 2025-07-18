pipeline {
    agent any

    tools {
        maven 'M3'       
        jdk 'jdk17'      
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Uzayisenga/mam-bdd-karate.git'
            }
        }
        stage('Build and Test') {
            steps {
                bat 'mvn clean test'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean install -DskipTests'
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

        stage('Upload to Zephyr') {
            steps {
                withCredentials([string(credentialsId: 'fa2cb66f-0fdc-43cf-8020-fd2d5ebf470c', variable: 'ZEPHYR_TOKEN')]) {
                    bat 'upload-to-zephyr.bat'
                }
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}
