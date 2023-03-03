def runSonarQubeAnalysis() {
  // Define the SonarQube properties
  def scannerHome = tool 'SonarQubeScanner'
  def sonarHostUrl = 'http://localhost:9000'
  def projectName = 'Myproject'
  def projectKey = 'my-project-key'
  def projectVersion = '1.0'
  def sourcesPath = 'src'
  def testsPath = 'tests'
  // Run the SonarQube Scanner
  withSonarQubeEnv('SonarQube') {
    sh """
      ${scannerHome}/bin/sonar-scanner \
      -Dsonar.host.url=${sonarHostUrl} \
      -Dsonar.projectName='${projectName}' \
      -Dsonar.projectKey='${projectKey}' \
      -Dsonar.projectVersion='${projectVersion}' \
      -Dsonar.sources='${sourcesPath}' \
      -Dsonar.tests='${testsPath}'
    """
  }
}
