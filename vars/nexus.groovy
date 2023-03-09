def call(Map config) {
    def groupId = config.groupId
    def artifactId = config.artifactId
    def version = config.version
    def packaging = config.packaging
    def file = config.file
    def repositoryUrl = config.repositoryUrl
    def username = config.username
    def password = config.password
    def nexusUrl = repositoryUrl + "/" + groupId.replaceAll("\\.", "/") + "/" + artifactId + "/" + version + "/" + artifactId + "-" + version + "." + packaging
    sh "curl -v -u ${username}:${password} --upload-file ${file} ${nexusUrl}"
}
