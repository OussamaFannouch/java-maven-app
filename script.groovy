def buildJar() {
    echo 'building the application...'
    sh 'mvn package'
}

def buildImage() {
    echo 'Building the Docker Image...'
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
        sh 'docker build -t oussamafannouch/demo-app:jma-2.0 .'
        sh "echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin"
        sh 'docker push oussamafannouch/demo-app:jma-2.0'
        }
}

def deployApp() {
    echo 'deploying the application...'
}
return this