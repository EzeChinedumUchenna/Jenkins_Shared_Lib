#!/usr/bin/env groovy

def branchName = env.BRANCH_NAME

// def call(String imageName){
//     echo "deploying image in ${branchName} to ACR ...."
//     withCredentials([usernamePassword(credentialsId: 'azure_acr_cred', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
//         sh "echo $PASS | docker login -u $USER --password-stdin nedumacr.azurecr.io"
//         sh "docker push $imageName"
//     }
// }

def call(String imageName, String branchName) {
    echo "deploying image in ${branchName} to ACR ...."
    withCredentials([usernamePassword(credentialsId: 'azure_acr_cred', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "echo $PASS | docker login -u $USER --password-stdin nedumacr.azurecr.io"
        sh "docker push $imageName"
    }
}
