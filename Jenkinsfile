pipeline {
  agent any 
  tools {
    maven 'Apache Maven 3.6.0'
    jdk 'java8'
    }
  stages {
    stage("initialize code"){
      steps {
        git 'https://github.com/saidinesh-p/covid19-dashboard.git'
        }
       }
     stage("mvn build"){
       steps{
         sh 'mvn clean package'
         }
        }
       }
      }
        
