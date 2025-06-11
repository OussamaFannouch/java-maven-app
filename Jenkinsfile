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
                    echo "Executing pipeline of branch $BRANCH_NAME"
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
