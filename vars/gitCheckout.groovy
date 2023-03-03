def call(Map config) {
    node {
        git url: "https://github.com/${config.name}/${config.repo}"
        sh 'mvn install'
        sh 'mvn clean install'
    }
}
