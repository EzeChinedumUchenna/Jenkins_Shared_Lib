#!/usr/bin/env groovy
def call(){
    echo "building the docker image..."
    sh "docker build -t nedumacr.azurecr.io/demo-app:jma-$IMAGE_NAME .
