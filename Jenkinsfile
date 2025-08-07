import java.net.URLEncoder
import groovy.json.JsonSlurper

pipeline {
    agent any

    parameters {
        string(name: 'ZEPHYR_PROJECT_KEY', defaultValue: 'SCRUM', description: 'Zephyr Scale Project Key')
        string(name: 'ZEPHYR_TARGET_PATH', defaultValue: 'src/test/resources/features/zephyr', description: 'Path to save downloaded feature files')
        string(name: 'ZEPHYR_TQL', defaultValue: 'status = "Approved"', description: 'TQL query for filtering test cases')
        booleanParam(name: 'CREATE_SAMPLE_IF_EMPTY', defaultValue: true, description: 'Create sample feature file if no test cases found')
        booleanParam(name: 'DEBUG', defaultValue: false, description: 'Enable debug output for Maven')
        booleanParam(name: 'SKIP_ZEPHYR_DOWNLOAD', defaultValue: false, description: 'Skip Zephyr download and use existing features')
        string(name: 'DEVELOP_TEST_KARATE_ENVIRONMENT', defaultValue: '', description: 'Karate environment for development tests')
        string(name: 'KARATE_ENVIRONMENT_OVERRIDE', defaultValue: '', description: 'Override Karate environment')
        string(name: 'DEVELOP_TEST_KARATE_OPTIONS', defaultValue: '', description: 'Karate options for development tests')
        string(name: 'KARATE_OPTIONS_OVERRIDE', defaultValue: '', description: 'Override Karate options')
        string(name: 'MVN_DEVELOP_TEST_SWITCHES', defaultValue: '', description: 'Maven switches for development tests')
        choice(name: 'ZEPHYR_ENDPOINT', choices: ['eu', 'us'], description: 'Zephyr Scale endpoint region')
        string(name: 'TEST_CYCLE_NAME', defaultValue: '', description: 'Custom test cycle name (auto-generated if empty)')
        booleanParam(name: 'AUTO_CREATE_TEST_CASES', defaultValue: true, description: 'Auto-create test cases in Zephyr if they don\'t exist')
    }

    tools {
        maven 'M3'
        jdk 'jdk17'
    }

    environment {
        FEATURES_DIR = 'src/test/resources/features'
        JIRA_BASE_URL = 'https://mileand.atlassian.net'
        ZEPHYR_CREDENTIAL_ID = '01041c05-e42f-4e53-9afb-17332c383af9'
    }

    stages {
        stage('Clean & Checkout') {
            steps {
                script {
                    echo "🧹 Cleaning workspace and checking out code..."
                    deleteDir()
                    git 'https://github.com/Uzayisenga/mam-bdd-karate.git'
                    sh '''
                        mkdir -p src/test/resources/features
                        mkdir -p target/karate-reports
                        mkdir -p target/surefire-reports
                    '''
                }
            }
        }

        stage('Validate Environment') {
            steps {
                script {
                    echo "🔍 Validating environment and project structure..."
                    sh '''
                        echo "Java version:"
                        java -version
                        echo "\\nMaven version:"
                        mvn -version
                    '''
                    def pomExists = fileExists('pom.xml')
                    def runnerExists = fileExists('src/test/java/com/milesandmore/testautomation/runners/KarateRunnerTest.java')
                    echo "📋 Project validation:"
                    echo "   - Maven POM exists: ${pomExists}"
                    echo "   - Karate runner exists: ${runnerExists}"

                    if (!pomExists) {
                        error "❌ No pom.xml found. This pipeline requires a Maven project."
                    }
                    sh '''
                        echo "\\n🔧 Step definition analysis:"
                        if [ -d "src/test/java" ]; then
                            echo "Java test files found:"
                            find src/test/java -name "*.java" -type f | head -10
                            echo "\\nStep definition files:"
                            find src/test/java -name "*.java" -exec grep -l "@Given\\|@When\\|@Then" {} \\; 2>/dev/null || echo "No step definitions found"
                        else
                            echo "No src/test/java directory found"
                        fi
                    '''
                }
            }
        }

        stage('Download Feature Files from Zephyr') {
            when {
                not {
                    expression { return params.SKIP_ZEPHYR_DOWNLOAD == true }
                }
            }
            steps {
                script {
                    echo "🔄 Downloading feature files from Zephyr Scale using the plugin..."
                    try {
                        zephyrDownloadFeatureFiles(
                            serverAddress: env.ZEPHYR_SERVER_ID,
                            projectKey: params.ZEPHYR_PROJECT_KEY,
                            targetPath: params.ZEPHYR_TARGET_PATH,
                            tql: params.ZEPHYR_TQL,
                            format: 'gherkin'
                        )
                        echo "✅ Download successful. Feature files saved to: ${params.ZEPHYR_TARGET_PATH}"
                    } catch (Exception e) {
                        echo "❌ Download failed: ${e.getMessage()}"
                        if (params.CREATE_SAMPLE_IF_EMPTY) {
                            echo "Creating a sample feature file to continue the pipeline."
                            createSampleFeatureFile()
                        } else {
                            error "Download failed and CREATE_SAMPLE_IF_EMPTY is false."
                        }
                    }
                }
            }
        }

        stage('Use Existing Features') {
            when {
                expression { return params.SKIP_ZEPHYR_DOWNLOAD == true }
            }
            steps {
                script {
                    echo "⏭️ Skipping Zephyr download, using existing feature files..."
                    def count = sh(
                        script: "find src/test/resources/features -name '*.feature' 2>/dev/null | wc -l || echo '0'",
                        returnStdout: true
                    ).trim()
                    echo "📊 Found ${count} existing feature files"

                    if (count == '0') {
                        echo "⚠️ No existing feature files found. Creating sample to proceed..."
                        createSampleFeatureFile()
                    }
                    sh """
                        echo '📁 Using feature files:'
                        find src/test/resources/features -name '*.feature' -exec echo '   {}' \\; | head -10
                    """
                }
            }
        }

        stage('Validate Test Setup') {
            steps {
                script {
                    echo "🔍 Validating test setup before execution..."
                    sh '''
                        echo "📋 Final project structure:"
                        echo "=========================="
                        FEATURE_COUNT=$(find src/test/resources/features -name "*.feature" | wc -l)
                        echo "Total feature files: $FEATURE_COUNT"
                        if [ "$FEATURE_COUNT" -gt 0 ]; then
                            echo "\\nFeature files:"
                            find src/test/resources/features -name "*.feature" | head -5
                            echo "\\nSample feature content:"
                            head -15 $(find src/test/resources/features -name "*.feature" | head -1)
                        fi
                        echo "\\n☕ Java test structure:"
                        if [ -d "src/test/java" ]; then
                            find src/test/java -name "*.java" -type f | head -5
                        fi
                        echo "\\n📦 Maven dependencies check:"
                        if [ -f "pom.xml" ]; then
                            grep -A 2 -B 2 "karate\\|cucumber" pom.xml | head -10 || echo "No Karate dependencies found in POM"
                        fi
                    '''
                }
            }
        }

        stage('Build and Run Karate Tests') {
            steps {
                script {
                    def runnerExists = fileExists('src/test/java/com/milesandmore/testautomation/runners/KarateRunnerTest.java')
                    def pomExists = fileExists('pom.xml')

                    echo "🔍 Test execution analysis:"
                    echo "   - Karate runner exists: ${runnerExists}"
                    echo "   - Maven POM exists: ${pomExists}"

                    if (pomExists) {
                        echo "✅ Executing Maven tests..."
                        try {
                            withMaven() {
                                def mvnCmd = buildMavenCommand(runnerExists)
                                echo "▶ Executing: ${mvnCmd}"
                                sh mvnCmd
                                echo "✅ Tests completed successfully"
                            }
                        } catch (Exception e) {
                            echo "⚠️ Test execution completed with issues: ${e.getMessage()}"
                            handleTestFailures()
                        }
                    } else {
                        echo "❌ No Maven configuration found"
                        createPlaceholderTestResults()
                    }
                }
            }
        }

        stage('Upload Results to Zephyr Scale') {
            steps {
                script {
                    echo "📤 Uploading test results to Zephyr Scale using the plugin..."
                    // Use the plugin step to publish test results.
                    // The plugin handles zipping, uploading, and API calls.
                    zephyrPublishTestResults(
                        serverAddress: env.ZEPHYR_SERVER_ID,
                        projectKey: params.ZEPHYR_PROJECT_KEY,
                        format: 'Cucumber', // Karate outputs Cucumber-compatible JSON
                        filePath: 'target/karate-reports/**/*.json',
                        autoCreateTestCases: params.AUTO_CREATE_TEST_CASES,
                        testCycleName: params.TEST_CYCLE_NAME ?: "Automated Run - ${env.BUILD_NUMBER}",
                        folderName: 'Karate Tests'
                    )
                    echo "✅ Results uploaded successfully."
                }
            }
        }
    }

    post {
        always {
            script {
                echo "📊 Publishing test results and artifacts..."
                junit testResults: 'target/surefire-reports/**/*.xml', allowEmptyResults: true
                cucumber(
                    jsonReportDirectory: 'target/karate-reports',
                    fileIncludePattern: '**/*.json',
                    mergeFeaturesById: true,
                    skipEmptyJSONFiles: true
                )

                archiveArtifacts artifacts: 'target/karate-reports/*.html', allowEmptyArchive: true
                archiveArtifacts artifacts: 'target/karate-reports/*.json', allowEmptyArchive: true
                archiveArtifacts artifacts: 'src/test/resources/features/*.feature', allowEmptyArchive: true
            }
        }
        success {
            echo "✅ Pipeline completed successfully!"
        }
        failure {
            echo "❌ Pipeline failed. Check the logs for details."
        }
        unstable {
            echo "⚠️ Pipeline completed with test failures."
        }
    }
}
def createSampleFeatureFile() { /*... (kept for pipeline robustness) ...*/ }
def createPlaceholderTestResults() { /*... (kept for pipeline robustness) ...*/ }
def buildMavenCommand(runnerExists) { /*... (kept for pipeline robustness) ...*/ }
def handleTestFailures() { /*... (kept for pipeline robustness) ...*/ }
def validateFeatureFiles() { /*... (kept for pipeline robustness) ...*/ }
def convertZephyrToGherkin(scriptContent) { /*... (kept if needed for manual generation) ...*/ }
def createKarateFeatureFile(issueKey, name, status, scriptContent) { /*... (kept if needed for manual generation) ...*/ }
def createPlaceholderFeatureFile(issueKey, name, status) { /*... (kept if needed for manual generation) ...*/ }
def handleNoTestCases() { /*... (kept for pipeline robustness) ...*/ }
def handleParsingError() { /*... (kept for pipeline robustness) ...*/ }