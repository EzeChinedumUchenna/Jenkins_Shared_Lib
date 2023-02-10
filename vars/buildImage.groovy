#!/usr/bin/env groovy
def call(){
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-ub-credentials', passwordVariable: 'PWD', usernameVariable: 'USER')]) {
        sh 'docker build -t nedumdocker/maven-java-nana:jma-2.0 .'
        sh "echo $PWD | docker login -u $USER --password-stdin"
        sh 'docker push nedumdocker/maven-java-nana:jma-2.0'
    }
}