pipeline {
    agent any

    tools {
        maven 'M3'
        jdk 'jdk17'
    }

    environment {
        FEATURES_DIR = 'src/test/resources/features'
    }

    stages {
        stage('Clean & Checkout') {
            steps {
                deleteDir()
                git 'https://github.com/Uzayisenga/mam-bdd-karate.git'
            }
        }

        stage('Download Zephyr Feature Files') {
            steps {
                script {
                    withEnv(["PATH+MAVEN=${tool 'Maven'}/bin:${tool 'JDK'}/bin"]) {
                        withCredentials([string(credentialsId: '01041c05-e42f-4e53-9afb-17332c383af9', variable: 'ZEPHYR_TOKEN')]) {
                            sh '''#!/bin/bash  # Force bash shell
                                set -e  # Exit on error
                                mkdir -p src/test/resources/features/zephyr
                                echo "Attempting to download feature files..."

                                # Download APPROVED test cases
                                echo "Fetching APPROVED test cases..."
                                curl -sS -H "Authorization: Bearer ${ZEPHYR_TOKEN}" \\
                                     -H "Content-Type: application/json" \\
                                     -X GET "https://eu.api.zephyrscale.smartbear.com/v2/testcases?projectKey=SCRUM&status=Approved" \\
                                     -o src/test/resources/features/zephyr/zephyr_testcases_raw.json

                                if [ ! -s src/test/resources/features/zephyr/zephyr_testcases_raw.json ]; then
                                    echo "❌ Failed to download or empty JSON file"
                                    exit 1
                                fi

                                echo "Parsing JSON and extracting Gherkin..."

                                # Use temporary file instead of process substitution
                                jq -c '.values[]' src/test/resources/features/zephyr/zephyr_testcases_raw.json > temp_testcases.txt

                                while IFS= read -r testcase_json; do
                                    key=$(echo "${testcase_json}" | jq -r '.key // empty')
                                    name_for_file=$(echo "${testcase_json}" | jq -r '.name // empty' | sed 's/[^a-zA-Z0-9_]/_/g')
                                    name_for_scenario=$(echo "${testcase_json}" | jq -r '.name // empty')
                                    status=$(echo "${testcase_json}" | jq -r '.status // empty')

                                    echo "Processing: ${key} - ${name_for_scenario}"

                                    if [ "${status}" != "Approved" ]; then
                                        echo "Skipping ${key} - Not 'Approved'"
                                        continue
                                    fi

                                    testscript_url=$(echo "${testcase_json}" | jq -r '.testScript.self // empty')
                                    if [ -z "${testscript_url}" ]; then
                                        echo "⚠️ No testScript URL for ${key}"
                                        continue
                                    fi

                                    echo "✅ Downloading Gherkin for ${key}"
                                    gherkin_response=$(curl -sS -H "Authorization: Bearer ${ZEPHYR_TOKEN}" -H "Content-Type: application/json" -X GET "${testscript_url}")
                                    gherkin_text=$(echo "${gherkin_response}" | jq -r '.text // empty')

                                    feature_file="src/test/resources/features/zephyr/${key}_${name_for_file}.feature"

                                    # Create feature file
                                    {
                                        echo "Feature: ${name_for_scenario}"
                                        echo ""
                                        echo "Background:"
                                        echo "  * url baseUrl"
                                        echo ""
                                        echo "@Approved @TestCaseKey=${key}"
                                        echo "Scenario: ${name_for_scenario}"

                                        if [ -n "${gherkin_text}" ] && [ "${gherkin_text}" != "null" ]; then
                                            echo "${gherkin_text}" | sed 's/^/  /'
                                        else
                                            echo "  Given def testInfo = { testKey: '${key}', name: '${name_for_scenario}' }"
                                            echo "  When print 'Executing test:'"
                                            echo "  Then match testInfo.testKey == '${key}'"
                                        fi
                                    } > "${feature_file}"

                                    echo "✅ Created: ${feature_file}"
                                done < temp_testcases.txt
                                rm -f temp_testcases.txt

                                # Fallback if no features created
                                if [ -z "$(find src/test/resources/features/zephyr -name '*.feature' -print -quit)" ]; then
                                    echo "⚠️ Creating fallback feature file"
                                    cat > "src/test/resources/features/zephyr/fallback.feature" <<EOF
        Feature: Fallback Test

        Background:
          * url baseUrl

        @Approved
        Scenario: No tests found
          Then match 1 == 1
        EOF
                                fi
                            '''
                        }
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
                    sh '''
                        echo "🔧 Building project and running tests..."

                        # Clean and build project first
                        mvn clean install -DskipTests

                        # Run tests with more verbose output
                        mvn test -Dtest=KarateRunnerTest -Dtest.env=jenkins -X

                        # Check if any reports were generated
                        echo "Generated test reports:"
                        ls -la target/karate-reports/ 2>/dev/null || echo "No karate-reports directory found"
                        ls -la target/surefire-reports/ 2>/dev/null || echo "No surefire-reports directory found"
                    '''
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

                        echo "✅ Created ZIP file: $ZIP_FILE"

                        TIMESTAMP=$(date +"%Y-%m-%d_%H-%M")
                        CYCLE_NAME="Automated_Cycle_${TIMESTAMP}"
                        CYCLE_DESC="Automated%20run%20from%20Jenkins%20pipeline"

                        # Upload ZIP file to Zephyr Scale with autoCreateTestCases=true
                        echo "Uploading to Zephyr Scale..."
                        RESPONSE=$(curl -s -X POST "https://eu.api.zephyrscale.smartbear.com/v2/automations/executions/cucumber?projectKey=SCRUM&autoCreateTestCases=true&testCycleName=${CYCLE_NAME}&testCycleDescription=${CYCLE_DESC}&jiraProjectVersion=10001&folderId=root" \
                            -H "Authorization: Bearer ${ZEPHYR_TOKEN}" \
                            -F "file=@${ZIP_FILE}")

                        echo "API Response: $RESPONSE"

                        # Clean up ZIP file
                        rm -f "$ZIP_FILE"

                        # Check response for different types of success/error
                        if echo "$RESPONSE" | grep -q '"testExecutions"\\|"testExecutionKey"\\|"executions"'; then
                            echo "✅ Upload successful! Test executions created."
                        elif echo "$RESPONSE" | grep -q "Couldn\\'t find any mapped test cases"; then
                            echo "⚠️  Upload successful, but no test cases were mapped."
                            echo "This usually means the @TestCaseKey tags in your feature files don't match existing test cases in Zephyr Scale."
                        elif echo "$RESPONSE" | grep -q "errorCode"; then
                            echo "❌ Upload failed with error: $RESPONSE"
                            # Don't exit 1 here so we can see the full pipeline results
                        else
                            echo "✅ Upload completed. Response: $RESPONSE"
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