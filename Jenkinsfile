pipeline {
	agent any
	stages {
		stage('build') {
			agent { docker { image 'maven:3.3.3' } }
			steps {
				sh 'mvn --version'
				sh 'cd HolygramSpring; mvn clean package'
				stash name: "app", includes: "**"
			}
		}
		stage('QualityTest') {
			agent { docker { image 'maven:3.3.3' } }
			steps {
				unstash "app"
				sh 'cd HolygramSpring; mvn clean test'
				sh 'cd HolygramSpring; mvn sonar:sonar \
					-Dsonar.projectKey=HolyGram \
					-Dsonar.organization=tibaroc-github \
					-Dsonar.host.url=https://sonarcloud.io \
					-Dsonar.login=82c3ddd2f5851e04646a37e942b0f20bfeeb5f7b'
			}
		}
		stage('IntegrationTest') {
			agent { 
				docker { 
					image 'lucienmoor/katalon-for-jenkins:latest'
					args '-p 8888:8080'
				}
			}
			steps {
				unstash "app"
				sh 'java -jar ./HolygramSpring/target/Thymeleaf-0.0.1-SNAPSHOT.jar > /dev/null 2>&1 &'
				sh 'sleep 10'
				sh 'chmod +x ./runTest.sh'
				sh './runTest.sh'
			}
		}
	}
}
