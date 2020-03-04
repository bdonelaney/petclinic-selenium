pipeline {
    agent {
        kubernetes {
            label 'functional-test-arunaapp'
            defaultContainer 'jnlp-agent'
        }
    }
//        stage('Pull source') {
//          checkout scm
//        }
    stages{
        stage('Prepare test') {
            steps {
                sh 'export no_proxy=127.0.0.1,localhost'
                sh 'mvn test'
                //sh 'netstat -tlpn'
                //sh 'curl -vL http://localhost:4444/wd/hub/static/resource/hub.html'
            }
            post {
                always {
                    archiveArtifacts artifacts: '**/*.png'
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
    }
}