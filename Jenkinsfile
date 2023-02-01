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
                dir('backend') {
                    sh 'mvn clean'
                }
                echo 'downloading github project...'
                git branch: 'main', credentialsId: 'root', url: 'https://github.com/aixia9988/CI-CD-pipeline.git'
            }
        }

        stage('build') {
            steps {
                dir ('backend'){
                  sh 'mvn test-compile'
                }
                echo 'building...'
                echo 'finished building'
            }
        }

        stage('test') {
            steps {
                dir ('backend'){
                  sh 'mvn surefire:test'
                }
                echo 'starting test.....'
                echo 'finished test'
            }
        }

        stage('package') {
            steps {
                dir ('backend'){
                  sh 'mvn war:war'
                }
                echo 'packaging...'
                echo 'packaged'
            }
        }

        stage ('deploy') {
           steps {
               dir ('backend'){
                   sh 'pwd' // prints /var/jenkins_home/workspace/YOUR_PROJECT_NAME/backend
                   sh 'cp backend/target/ROOT.war /artifacts'
               }
           }
        }


    post {
        always {
            echo 'generating test report....'
            sh 'ls ./backend/target/surefire-reports'

        failure {
              echo 'it has failed or something'}
        }
    }
}