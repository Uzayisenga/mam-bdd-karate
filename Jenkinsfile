pipeline {
    agent any

    tools {
        maven 'M3'       // Replace with the actual name of your Maven install
        jdk 'jdk17'      // Replace with the actual name of your JDK install
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
