def call(Map config) {
  stage('Sonar') {
    withSonarQubeEnv('SonarQube Scanner for Jenkins') {
      sh "mvn sonar:sonar -Dsonar.projectKey=${config.projectKey} -Dsonar.projectName=${config.projectName} -Dsonar.projectVersion=${config.projectVersion}"
    }
  }
}
