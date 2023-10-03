#!/usr/bin/env groovy

def call(){
    echo "deploying image to ACR ...."
    withCredentials([usernamePassword(credentialsId: 'azure_acr_cred', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "echo $PASS | docker login -u $USER --password-stdin nedumacr.azurecr.io"
        sh 'docker push nedumacr.azurecr.io/demo-app:jma-${BUILD_NUMBER}'
    }
}
