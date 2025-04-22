pipeline {
    agent any
    tools{
        gradle 'gradle_8.13'
    }
    stages {
        stage('Gradle Build') {
            steps {
              checkout scmGit(branches: [[name: '*/main']], extensions: [],
              userRemoteConfigs: [[url: 'https://github.com/PurnaSesham/TodosApp']])
              bat 'gradlew clean build'
            }
        }
        stage('Build Docker Image') {
            steps {
                 script{
                     bat 'docker build -t psesham/todosapp .'
                 }
            }
        }
        stage('Push Image to Hub') {
            steps {
                 script {
                     bat 'docker login -u psesham -p Docker@7793'
                     bat 'docker push psesham/todosapp'
                 }
            }
        }
    }
}
