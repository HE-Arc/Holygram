pipeline {
    agent any
    stages {
        stage('Build') { 
            agent {
              docker {
               image 'maven:3-alpine'
              }
            }
            steps {
			sh '(cd ./SpringTestDemo/; mvn clean package)'
		stash name: "app", includes: "**"



            }
        }
	stage('QualityTest') { 
            agent {
              docker {
               image 'maven:3-alpine'
              }
            }
            steps {
		    unstash "app"
			sh '(cd ./SpringTestDemo/; mvn clean test)'
		    sh '(cd ./SpringTestDemo/; mvn sonar:sonar -Dsonar.projectKey=LucienMoor_SpringTest -Dsonar.organization=lucienmoor-github -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=e800ab354b87736aaef7152b13db882e01bd6763)'
	    }
        }
        stage('IntegrationTest'){
		agent{ 
			docker{
				image 'lucienmoor/katalon-for-jenkins:latest'
				args '-p 8888:8080'
			}
		}
		   steps {
			unstash "app"
			sh 'java -jar ./SpringTestDemo/target/SpringTestDemo-0.0.1-SNAPSHOT.jar >/dev/null 2>&1 &' 
			sh 'sleep 30'
			sh 'chmod +x ./runTest.sh'
			sh './runTest.sh'

			cleanWs()

		    }
            
        }
    }
       post {
        always {
            echo 'always clean up'
            deleteDir()
        }
    }
}
