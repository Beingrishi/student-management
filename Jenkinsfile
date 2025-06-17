pipeline {
    agent any

    tools {
        maven 'Maven 3.9'
        jdk 'Java 21'
    }

    environment {
        SONAR_SCANNER_HOME = tool 'SonarScanner'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', credentialsId: 'your-git-creds-id', url: 'https://github.com/Beingrishi/student-management.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('LocalSonar') {
                    bat "${env.SONAR_SCANNER_HOME}\\bin\\sonar-scanner.bat"
                }
            }
        }

        stage('Publish Test Results') {
            steps {
                junit 'target/surefire-reports/*.xml'
            }
        }
    }
}
