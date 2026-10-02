pipeline {
    
      agent any
     
         tools {
           maven 'Maven-3.8.7'
          } 
  
      stages  {
          stage ('Checkout') {
           steps {
            checkout scm
           }
        }
        
        stage ('Build') {
          steps {
          echo 'Building Application....'
           sh 'mvn clean compile'
            }
          }
        stage ('Test') {
          steps {
          echo 'Running Unit Tests....'
            sh 'mvn test'
          }
        }
       stage ('Package') {
         steps {
         echo 'Creating War File.....'
           sh 'mvn clean package'
            }
          }
        stage ('SonarQube Analysis') {
          steps {
             echo 'Running SonarQube Analysis'

             withCredentials([string(credentialsId: 'sonar-token', variable: 'SONAR_TOKEN')]) {
            sh '''
               mvn sonar:sonar \
               -Dsonar.projectkey=user-application \
               -Dsonar.host.url=http://13.203.221.206:9000 \
               -Dsonar.token=$SONAR_TOKEN
              '''
            }
          }
       }
       stage ('Deploy to Nexus') {
          steps {
            echo 'Uploading artifact to Nexus'
             sh 'mvn deploy -s settings.xml'
                }
             }
       stage ('Tomcat Deployment'){
          steps {
            echo 'Deploying Application to Tomcat.....'
            
              sh '''
                 cp target/user-application-1.0-SNAPSHOT.war /var/lib/tomcat10/webapps/
              '''
                }
             }
          }
       post {
          success {
              echo 'pipeline completed successfully'
              
                emailext (
                to: 'adimulamsai01@gmail.com',
                subject: "Success: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: "pipeline completed successfully."
                 )   
               }
             
         failure {
             echo 'pipeline failure'

            emailext (
                to: 'adimulamsai01@gmail.com',
                subject: "Failure: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: "pipeline failure, check the console output."
                 )
          }
       }
    }
