pipeline {
    agent any
    
     triggers { pollSCM '* * * * *' }
     options {
    buildDiscarder(logRotator(numToKeepStr: '2', artifactNumToKeepStr: '2'))
  }

    environment {
        AWS_ACCESS_KEY_ID     = credentials('jenkins-aws-secret-key-id')
        AWS_SECRET_ACCESS_KEY = credentials('jenkins-aws-secret-access-key')
        ARTIFACT_NAME = "wallet-${BUILD_ID}.jar"
        AWS_S3_BUCKET = 'terradeployRaph'
        AWS_EB_APP_NAME = 'walletapp'
        AWS_EB_ENVIRONMENT = 'walletapp-env'
        AWS_EB_APP_VERSION = "${BUILD_ID}"
    }
 
   
    stages {
        stage('Checkout Project') {
          
            steps {
                echo "-=- Checout project -=-"
                git branch: 'main', url: 'https://github.com/Raphael-lvt/repoApiWallet'
            }
        }
        
       stage('Compile') {
            steps {
                echo "-=- Compile project -=-"
                sh 'mvn compile'
            }
        }
        stage('Test') {
            steps {
                echo "-=- Test project -=-"
                sh 'mvn test -Dspring.profiles.active=jenkins'
            }
            
            post {
                success {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        } 
        
        stage ('Package') {
            steps {
                echo "-=- Package project -=-"
                sh 'mvn package -DskipTests'
            } 
            post {
                always {
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            } 
        }
        
        stage('Copy JAR to S3') {
                   steps{
                            sh 'aws configure set region eu-west-3'
                            sh 'aws s3 cp target/*.jar s3://$AWS_S3_BUCKET/$ARTIFACT_NAME'
                            sh 'sleep 10'
                                                
            }
        }
        stage('ELasticbean Deployment from S3') {
                    steps{
                sh 'aws elasticbeanstalk create-application-version --application-name $AWS_EB_APP_NAME --version-label $AWS_EB_APP_VERSION --source-bundle S3Bucket=$AWS_S3_BUCKET,S3Key=$ARTIFACT_NAME'
                sh 'aws elasticbeanstalk update-environment --application-name $AWS_EB_APP_NAME --environment-name $AWS_EB_ENVIRONMENT --version-label $AWS_EB_APP_VERSION'
                }
        }
       
        
        
        
        
    }
}
