pipeline {
  agent any 
  tools {
    maven 'Apache Maven 3.6.0'
    jdk 'java8'
    }
  stages {
    stage("initialize code"){
      steps {
        git credentialsId: '4eadea32-908f-473c-a5d2-01b38e97e6f7', url: 'https://github.com/saidinesh-p/covid19-dashboard.git'
        }
       }
     stage("mvn build"){
       steps{
         sh 'mvn clean package'
         }
        }
       }
      }
        
