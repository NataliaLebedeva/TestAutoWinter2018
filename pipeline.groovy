node {
    def failedJobName = "";

    stage('init') {
        git 'https://github.com/NataliaLebedeva/TestAutoWinter2018'
        sh 'mvn clean compile'
    }

    stage('test hw1') {
        try {
            sh 'mvn test -P hw1'
        } catch (e) {
            failedJobName = "test hw1"
            echo "${e}"
        }
    }

    stage('test hw3') {
        try {
            sh 'mvn test -P hw3'
        } catch (e) {
            failedJobName = "test hw3"
            echo "${e}"
        }
    }

    stage('test hw4') {
        try {
            sh 'mvn test -P hw4'
        } catch (e) {
            failedJobName = "test hw4"
            echo "${e}"
        }
    }

    stage('report') {
        sh 'mvn site'

        publishHTML(
                [allowMissing: false,
                 alwaysLinkToLastBuild: false,
                 keepAll: false,
                 reportDir: 'target/site/allure-maven-plugin',
                 reportFiles: 'index.html',
                 reportName: 'HTML Report',
                 reportTitles: ''
                ])

        if(!failedJobName.isEmpty())
            error "Build has failed on job: ${failedJobName} !"
    }
}