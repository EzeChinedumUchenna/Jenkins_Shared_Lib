#!/usr/bin/env groovy
def call(){
    echo "Building the application in .jar."
    sh 'mvn package'
}