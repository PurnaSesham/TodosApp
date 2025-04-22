pipeline {
    agent any
    tools {
        gradle 'gradle_8.13'
    }
    environment {
            AWS_ACCESS_KEY_ID = credentials('aws-access-key-id') // Jenkins credentials ID
            AWS_SECRET_ACCESS_KEY = credentials('aws-secret-access-key') // Jenkins credentials ID
            //S3_BUCKET = 'purnas-test'
            REGION = 'ap-south-1'
            //JAR_NAME = 'TodosApp-0.0.1-SNAPSHOT.jar'
            STACK_NAME = 'MySpringBootS3Stack'
            TEMPLATE_FILE = 'infrastructure/s3-bucket.yaml'
    }
    stages {
        stage('Gradle Build') {
            steps {
              checkout scmGit(branches: [[name: '*/main']], extensions: [],
              userRemoteConfigs: [[url: 'https://github.com/PurnaSesham/TodosApp']])
              bat 'gradlew clean build'
            }
        }
        /* stage('Jar Upload to S3') {
            steps {
                script {
                    bat """
                        aws configure set aws_access_key_id %AWS_ACCESS_KEY_ID%
                        aws configure set aws_secret_access_key %AWS_SECRET_ACCESS_KEY%
                        aws configure set default.region %REGION%

                        aws s3 cp build/libs/%JAR_NAME% s3://%S3_BUCKET%/%JAR_NAME%
                    """
                }
            }
        } */
        stage('Create S3 Bucket via CloudFormation') {
                    steps {
                        script {
                            bat """
                            aws configure set aws_access_key_id %AWS_ACCESS_KEY_ID%
                            aws configure set aws_secret_access_key %AWS_SECRET_ACCESS_KEY%
                            aws configure set default.region %REGION%

                            aws cloudformation deploy \
                                --template-file %TEMPLATE_FILE% \
                                --stack-name %STACK_NAME% \
                                --capabilities CAPABILITY_NAMED_IAM
                            """
                        }
                    }
        }
    }
}
