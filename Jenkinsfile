pipeline {
    agent any

    parameters {
        // Define parameters expected by the new downloadFeatureFiles stage
        string(name: 'ZEPHYR_PROJECT_KEY', defaultValue: 'SCRUM', description: 'Zephyr Scale Project Key')
        string(name: 'ZEPHYR_TARGET_PATH', defaultValue: 'src/test/resources/features/zephyr', description: 'Path to save downloaded feature files')
        booleanParam(name: 'DEBUG', defaultValue: false, description: 'Enable debug output for Maven')
        string(name: 'DEVELOP_TEST_KARATE_ENVIRONMENT', defaultValue: '', description: 'Karate environment for development tests')
        string(name: 'KARATE_ENVIRONMENT_OVERRIDE', defaultValue: '', description: 'Override Karate environment')
        string(name: 'DEVELOP_TEST_KARATE_OPTIONS', defaultValue: '', description: 'Karate options for development tests')
        string(name: 'KARATE_OPTIONS_OVERRIDE', defaultValue: '', description: 'Override Karate options')
        string(name: 'MVN_DEVELOP_TEST_SWITCHES', defaultValue: '', description: 'Maven switches for development tests')
    }

    tools {
        maven 'M3'
        jdk 'jdk17'
    }

    environment {
        FEATURES_DIR = 'src/test/resources/features'
        // Define TQL for approved status, consistent with previous API call
        TQL = 'status = "Approved"'
        // Base Jira URL for Zephyr Scale integration, derived from the provided link
        JIRA_BASE_URL = 'https://mileand.atlassian.net'
    }

    stages {
        stage('Clean & Checkout') {
            steps {
                deleteDir()
                git 'https://github.com/Uzayisenga/mam-bdd-karate.git'
            }
        }

        stage('Download Approved Feature Files from Zephyr') {
            steps {
                // Clean old features before downloading new ones
                sh 'rm -rf src/test/resources/features/* || true'

                // Use the shared library function to download approved features
                script {
                    // Assuming 'mmgUat' is a loaded shared library that contains 'downloadFeatureFiles'
                    // The 'withCredentials' block is kept here, assuming downloadFeatureFiles might still
                    // implicitly use the ZEPHYR_TOKEN or it's needed for other parts of the shared library.
                    withCredentials([string(credentialsId: '01041c05-e42f-4e53-9afb-17332c383af9', variable: 'ZEPHYR_TOKEN')]) {
                        // Call the shared library function to download feature files
                        // Note: 'Abgenommen' parameter is assumed to be handled internally by the shared library
                        // to filter for approved tests, or 'tql' takes precedence for filtering.
                        // Based on the user's snippet, 'Abgenommen: true' is present.
                        mmgUat.downloadFeatureFiles(
                            serverAddress: env.JIRA_BASE_URL, // Use the defined Jira base URL
                            projectKey: params.ZEPHYR_PROJECT_KEY,
                            Abgenommen: true, // This parameter is specific to the shared library function
                            tql: env.TQL, // Use the defined TQL for explicit status filtering
                            targetPath: params.ZEPHYR_TARGET_PATH
                        )
                    }
                }

                // Confirm files were downloaded
                script {
                    def count = sh(script: "find ${params.ZEPHYR_TARGET_PATH} -name '*.feature' | wc -l", returnStdout: true).trim()
                    echo "Found ${count} feature files in ${params.ZEPHYR_TARGET_PATH}"
                    if (count == '0') {
                        error "❌ No approved test cases downloaded from Zephyr. Build aborted."
                    }
                }
            }
        }

        stage('Verify Step Definitions') {
            steps {
                script {
                    sh '''
                        echo "📋 Checking for step definitions..."

                        # Look for step definition files
                        find src -name "*.java" -type f | grep -i step | head -10

                        # Check if there are any Java files that might contain step definitions
                        echo "Java files in test directory:"
                        find src/test -name "*.java" -type f | head -10

                        # Show the structure of test directory
                        echo "Test directory structure:"
                        ls -la src/test/java/ 2>/dev/null || echo "No src/test/java directory found"

                        # Check if there are any existing Karate feature files for reference
                        echo "Existing feature files (excluding Zephyr downloads):"
                        find src/test/resources/features -name "*.feature" -not -path "*/zephyr/*" | head -5
                    '''
                }
            }
        }

        stage('Build and Run Karate Tests') {
            steps {
                script {
                    // This section uses functions from the 'mmgUat' shared library
                    if (mmgUat.isKarateTest()) {
                        withMaven() {
                            def argLine = ""
                            def karateEnv = mmgUat.determineTargetEnvironment(params.DEVELOP_TEST_KARATE_ENVIRONMENT, params.KARATE_ENVIRONMENT_OVERRIDE)
                            def karateOpts = mmgUat.determineTargetOptions(params.DEVELOP_TEST_KARATE_OPTIONS, params.KARATE_OPTIONS_OVERRIDE)
                            if (karateEnv) argLine += "-Dkarate.env=${karateEnv} "
                            if (karateOpts) argLine += "-Dkarate.options='${karateOpts}'"
                            def debugSwitch = params.DEBUG == 'true' ? "-X -e" : ""
                            // Clean the switches parameter to ensure no malformed content
                            def mavenSwitches = params.MVN_DEVELOP_TEST_SWITCHES?.trim() ?: ""
                            // Build the command more carefully
                            def cmd = "mvn clean test"
                            if (mavenSwitches) cmd += " ${mavenSwitches}"
                            if (debugSwitch) cmd += " ${debugSwitch}"
                            cmd += " -Dtest=com.milesandmore.testautomation.runners.KarateRunnerTest"
                            if (argLine) cmd += " -DargLine=\"${argLine}\""
                            echo "▶ Running: ${cmd}"
                            sh cmd
                        }
                    } else {
                        echo '⚠ Not a Karate test project'
                    }
                }
            }
        }

        stage('Upload Karate Results to Zephyr Scale (JAR)') {
            environment {
                ZEPHYR_TOKEN = credentials('01041c05-e42f-4e53-9afb-17332c383af9')
            }
            steps {
                script {
                    sh '''
                        echo "📤 Uploading Karate JSON to Zephyr Scale using JAR..."

                        FILE=$(ls target/karate-reports/*.json 2>/dev/null | head -n 1)
                        if [ ! -f "$FILE" ]; then
                            echo "❌ Karate JSON report not found! No JSON to upload."
                            echo "Available files in target directory:"
                            ls -la target/ 2>/dev/null || echo "No target directory found"
                            echo "Available files in karate-reports:"
                            ls -la target/karate-reports/ 2>/dev/null || echo "No karate-reports directory found"
                            exit 1
                        fi

                        echo "Found JSON file: $FILE"

                        # Show content of JSON file for debugging
                        echo "JSON file content preview:"
                        head -20 "$FILE"
                        echo "... (truncated)"

                        # Create ZIP file using jar command (part of JDK)
                        ZIP_FILE="cucumber-results.zip"
                        echo "Creating ZIP file using jar command..."

                        # Create temporary directory structure for jar
                        mkdir -p temp_zip
                        cp "$FILE" temp_zip/

                        # Create ZIP using jar
                        cd temp_zip
                        jar -cfM "../$ZIP_FILE" "$(basename "$FILE")"
                        cd ..

                        # Clean up temp directory
                        rm -rf temp_zip

                        if [ ! -f "$ZIP_FILE" ]; then
                            echo "❌ Failed to create ZIP file with jar!"
                            exit 1
                        fi

                        echo "✅ Created ZIP file: ${ZIP_FILE}"

                        TIMESTAMP=$(date +"%Y-%m-%d_%H-%M")
                        CYCLE_NAME="Automated_Cycle_${TIMESTAMP}"
                        CYCLE_DESC="Automated%20run%20from%20Jenkins%20pipeline"

                        # Upload ZIP file to Zephyr Scale with autoCreateTestCases=true
                        echo "Uploading to Zephyr Scale..."
                        RESPONSE=$(curl -s -X POST "https://eu.api.zephyrscale.smartbear.com/v2/automations/executions/cucumber?projectKey=SCRUM&autoCreateTestCases=true&testCycleName=${CYCLE_NAME}&testCycleDescription=${CYCLE_DESC}&jiraProjectVersion=10001&folderId=root" \
                            -H "Authorization: Bearer ${ZEPHYR_TOKEN}" \
                            -F "file=@${ZIP_FILE}")

                        echo "API Response: ${RESPONSE}"

                        # Clean up ZIP file
                        rm -f "${ZIP_FILE}"

                        # Check response for different types of success/error
                        if echo "${RESPONSE}" | grep -q '"testExecutions"\\|"testExecutionKey"\\|"executions"'; then
                            echo "✅ Upload successful! Test executions created."
                        elif echo "${RESPONSE}" | grep -q "Couldn\\'t find any mapped test cases"; then
                            echo "⚠️  Upload successful, but no test cases were mapped."
                            echo "This usually means the @TestCaseKey tags in your feature files don't match existing test cases in Zephyr Scale."
                        elif echo "${RESPONSE}" | grep -q "errorCode"; then
                            echo "❌ Upload failed with error: ${RESPONSE}"
                            // Don't exit 1 here so we can see the full pipeline results
                        else
                            echo "✅ Upload completed. Response: ${RESPONSE}"
                        fi
                    '''
                }
            }
        }

    }

    post {
        always {
            junit testResults: 'target/surefire-reports/**/*.xml', allowEmptyResults: true
            cucumber jsonReportDirectory: 'target/karate-reports', fileIncludePattern: '**/*.json', mergeFeaturesById: true, skipEmptyJSONFiles: true
            archiveArtifacts artifacts: 'target/karate-reports/*.html', allowEmptyArchive: true
            archiveArtifacts artifacts: 'target/karate-reports/*.json', allowEmptyArchive: true
        }
    }
}
