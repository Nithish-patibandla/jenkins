pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                script {
                    // Install Node.js and npm
                    def nodeVersion = '14'
                    def npmRegistry = 'https://registry.npmjs.org/'
                    tool name: "NodeJS ${nodeVersion}", type: 'jenkins.plugins.nodejs.tools.NodeJSInstallation'

                    // Install dependencies
                    sh "npm install --registry=${npmRegistry}"

                    // Build the application (replace 'npm run build' with your build script)
                    sh "npm run build"
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    // Run tests (replace 'npm test' with your test script)
                    sh "npm test"
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    // Deploy to production (replace this with your deployment steps)
                    echo "Deploying to production..."
                }
            }
    

