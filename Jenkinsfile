pipeline{
    agent any
    tools {
        maven 'maven-3.9'
    }
    stages {
        stage('test') {
            steps {
                script {
                    echo 'Running tests...'
                }
            }
        }
        stage('Build') {
            when {
                expression {
                    env.BRANCH_NAME == 'master'
                }
            }
            steps {
                script{
                    gv.buildJar()
                }   
            }
        }
        stage('Deploy') {
            when {
                expression {
                    env.BRANCH_NAME == 'master'
                }
            }
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }
}
