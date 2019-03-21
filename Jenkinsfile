pipeline {
	agent { docker { image 'maven:3.3.3' } }
	stages {
		stage('build') {
			steps {
				sh 'mvn --version'
				sh 'cd HolygramSpring; mvn clean test'
			}
		}
		stage('QualityTest') {
			steps {
				sh 'cd HolygramSpring; mvn clean test'
				sh 'cd HolygramSpring; mvn sonar:sonar \
					-Dsonar.projectKey=HolyGram \
					-Dsonar.organization=tibaroc-github \
					-Dsonar.host.url=https://sonarcloud.io \
					-Dsonar.login=82c3ddd2f5851e04646a37e942b0f20bfeeb5f7b'
			}
		}
	}
}
