pipeline{
    agent any
    tools {
        maven 'maven-3.9'
    }
    stages {
        stage('Build Jar') {
            steps {
                script{
                    echo 'Building the application...'
                    sh 'mvn package'
                }   
            }
        }
        stage('Build Image') {
            steps {
                script{
                    echo 'Building the Docker Image...'
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                        sh 'docker build -t oussamafannouch/demo-app:jma-2.0 .'
                        sh "echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin"
                        sh 'docker push oussamafannouch/demo-app:jma-2.0'
                    }
                }   
            }
        }
        stage('Deploy') {
            steps {
                script {
                    echo 'Deploying Application...'
                    // Add your deployment commands here
                }
            }
        }
    }
}