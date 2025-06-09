def gv



pipeline {
    agent any
    parameters {
        choice(name: 'VERSION', choices: ['1.0', '2.0', '3.0'], description: 'Select the version to build')
        booleanParam(name: 'executeTEST', defaultValue: true, description: 'Whether to run tests')
    }
    
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
                echo 'Building the application...'
            }
        }
        stage("build") {
            steps {
                script {
                    gv.buildApp()
                }
                echo 'Building the application...'
            }
        }
        stage("test") {
            when{
                expression{
                    params.executeTEST
                }
            }
            steps {
                script {
                    gv.testApp()
                }
                echo 'Running tests...'
            }
        }
        stage("deploy") {
            input{
                message 'Do you want to deploy the application?'
                ok 'done'
                parameters {
                            choice(name: 'ENV', choices: ['dev', 'staging', 'prod'], description: 'Select the version to build')                    
                }
            }
            steps {
                echo 'Deploying the application...'
                echo "Deploying version: ${params.VERSION}"
                echo "Deploying to environment: ${params.ENV}"
            }
        }
    }
    post {
        always {
            echo 'This will always run after the stages complete.'
        }
        success {
            echo 'This will run only if all stages were successful.'
        }
        failure {
            echo 'This will run only if any stage fails.'
        }
    }
}
