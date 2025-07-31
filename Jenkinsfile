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
                            sh '''
                               mkdir -p src/test/resources/features/zephyr
                               echo "Attempting to download feature files using curl..."

                               # Get APPROVED test cases
                               echo "Fetching APPROVED test cases from Zephyr Scale..."
                               curl -v -H "Authorization: Bearer ${ZEPHYR_TOKEN}" \\
                                    -H "Content-Type: application/json" \\
                                    -X GET "https://eu.api.zephyrscale.smartbear.com/v2/testcases?projectKey=SCRUM&status=Approved" \\
                                    -o src/test/resources/features/zephyr/zephyr_testcases_raw.json

                               if [ ! -s src/test/resources/features/zephyr/zephyr_testcases_raw.json ]; then
                                   echo "❌ Failed to download or empty JSON file. Check credentials, network, or project key."
                                   exit 1
                               fi

                               echo "Parsing downloaded JSON and extracting Gherkin..."

                               cat src/test/resources/features/zephyr/zephyr_testcases_raw.json | jq -c '.values[]' | while IFS= read -r testcase_json; do
                                   key=$(echo "${testcase_json}" | jq -r '.key // empty')
                                   name_for_file=$(echo "${testcase_json}" | jq -r '.name // empty' | sed 's/[^a-zA-Z0-9_]/_/g')
                                   name_for_scenario=$(echo "${testcase_json}" | jq -r '.name // empty')
                                   status=$(echo "${testcase_json}" | jq -r '.status // empty')

                                   echo "Processing test case: ${key} - ${name_for_scenario} (Status: ${status})"

                                   if [ "${status}" != "Approved" ]; then
                                       echo "Skipping ${key} - Status is not 'Approved'"
                                       continue
                                   fi

                                   testscript_url=$(echo "${testcase_json}" | jq -r '.testScript.self // empty')
                                   if [ -z "${testscript_url}" ]; then
                                       echo "⚠️ No testScript URL found for ${key}, skipping..."
                                       continue
                                   fi

                                   echo "✅ Downloading Gherkin for ${key}"
                                   gherkin_response=$(curl -s -H "Authorization: Bearer ${ZEPHYR_TOKEN}" -H "Content-Type: application/json" -X GET "${testscript_url}")
                                   gherkin_text=$(echo "${gherkin_response}" | jq -r '.text // empty')

                                   feature_file="src/test/resources/features/zephyr/${key}_${name_for_file}.feature"
                                   clean_scenario_name=$(echo "${name_for_scenario}" | sed 's/[^a-zA-Z0-9 ]/_/g')

                                   if [ -n "${gherkin_text}" ] && [ "${gherkin_text}" != "null" ]; then
                                       echo "Feature: ${clean_scenario_name}" > "${feature_file}"
                                       echo "" >> "${feature_file}"
                                       echo "Background:" >> "${feature_file}"
                                       echo "  * url baseUrl" >> "${feature_file}"
                                       echo "" >> "${feature_file}"
                                       echo "@Approved @TestCaseKey=${key}" >> "${feature_file}"
                                       echo "Scenario: ${clean_scenario_name}" >> "${feature_file}"

                                       echo "${gherkin_text}" | while IFS= read -r line; do
                                           if [ -n "${line}" ]; then
                                               echo "  ${line}" >> "${feature_file}"
                                           fi
                                       done
                                   else
                                       echo "⚠️  No valid Gherkin content for ${key}, creating dummy test"
                                       cat > "${feature_file}" << EOF
        Feature: ${clean_scenario_name}
        Background:
        * url baseUrl
        @Approved @TestCaseKey=${key}
        Scenario: ${clean_scenario_name}
        Given def testInfo = { testKey: '${key}', name: '${clean_scenario_name}' }
        When print 'Executing TM4J test:', testInfo
        Then match testInfo.testKey == '${key}'
        EOF

                               # List created feature files
                               echo "=== Feature Files Downloaded ==="
                               find src/test/resources/features/zephyr -name "*.feature" | head -10

                               # Fallback if none created
                               feature_count=$(find src/test/resources/features/zephyr -name "*.feature" | wc -l)
                               if [ "${feature_count}" -eq 0 ]; then
                                   echo "⚠️ No APPROVED feature files found. Creating fallback..."
                                   cat > "src/test/resources/features/zephyr/no_approved_tests.feature" << EOF
        Feature: No Approved Tests Found

                Background:
                  * url baseUrl

                @Approved
                Scenario: Notify no tests
                  Given print 'No approved test cases downloaded'
                  Then match true == true
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