pipeline {
    //agent { label 'agent1' }
    agent any

    tools {
        // Run the Maven installation named "3.8.7" and add it to the path.
        maven "MY_MAVEN"
    }

    stages {
        stage('clean and checkout') {
            steps {
                sh 'mvn clean'
                echo 'downloading github project...'
                git branch: 'main', credentialsId: 'root', url: 'https://github.com/aixia9988/CI-CD-pipeline.git'
            }
        }

        stage('build') {
            steps {
                echo 'building...'
                sh 'mvn test-compile'
                echo 'finished building'
            }
        }

        stage('test') {
            steps {
                echo 'starting test.....'
                sh 'mvn surefire:test'
                echo 'finished test'
            }
        }

        stage('package') {
            steps {
                echo 'packaging...'
                sh 'mvn war:war'
                echo 'packaged'
            }
        }
    }

    post {
        always {
            echo 'generating test report....'
            junit 'target/*reports/**/*.xml'
            echo 'test report generated'
        }
    }
}