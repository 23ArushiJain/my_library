def call(Map config) {
  stage('Sonar') {
    withSonarQubeEnv('sonarqube') {
      sh "mvn sonar:sonar -Dsonar.projectKey=${config.projectKey} -Dsonar.projectName=${config.projectName} -Dsonar.projectVersion=${config.projectVersion}"
    }
  }
}
