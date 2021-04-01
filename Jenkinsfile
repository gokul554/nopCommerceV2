pipeline {
    agent { any:any }
    stages {
        stage('clone repository') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'giltab', url: 'git@github.com:gokul554/nopCommerceV2.git']]])
         sh 'ls'
            }
        }
    }
}
