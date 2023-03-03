 def call(Map config = [:]) {
    sh "docker image build -t ${config.image}/${config.tag}:beta-${env.BRANCH_NAME}-${env.BUILD_NUMBER} ."
    withCredentials([usernamePassword(
            credentialsId: "doc",
            usernameVariable: "USER",
            passwordVariable: "PASS"
    )]) {
        sh "docker login -u '$USER' -p '$PASS'"
    }
    sh "docker image push ${config.hubUser}/${config.project}:beta-${env.BRANCH_NAME}-${env.BUILD_NUMBER}"
}


