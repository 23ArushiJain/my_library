def call(Map config) {
  stage('Sonar') {
    withSonarQubeEnv('sonarqube') {
      sh "mvn sonar:sonar -Dsonar.projectKey=${config.projectKey} -Dsonar.login=${config.login} -Dsonar.projectVersion=${config.projectVersion} -Dsonar.host.url=${config.hostUrl}"
    }
  }
}
