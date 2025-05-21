pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'intnumber/project4:latest'
        DOCKERHUB_CREDENTIALS = credentials('dockerhub-creds')
    }

    triggers {
        githubPush()
    }

    stages {
        stage('Clone Repo') {
            steps {
                git branch: 'main', url: 'https://github.com/Serdar-Sara/project4.git'
            }
        }

        stage('Build App') {
            steps {
                sh './gradlew build'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "docker build -t $DOCKER_IMAGE ."
            }
        }

        stage('Login to Docker Hub') {
            steps {
                sh "echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin"
            }
        }

        stage('Push Docker Image') {
            steps {
                sh "docker push $DOCKER_IMAGE"
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                sh 'kubectl apply -f k8s/deployment.yaml'
                sh 'kubectl apply -f k8s/service.yaml'
            }
        }
    }
}
