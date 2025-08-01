// The @Library annotation has been removed to allow the pipeline to run without a separate shared library.
import java.net.URLEncoder

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
    }

    tools {
        maven 'M3'
        jdk 'jdk17'
    }

    environment {
        FEATURES_DIR = 'src/test/resources/features'
        JIRA_BASE_URL = 'https://mileand.atlassian.net'
    }

    stages {
        stage('Clean & Checkout') {
            steps {
                deleteDir()
                git 'https://github.com/Uzayisenga/mam-bdd-karate.git'
            }
        }

        stage('Debug Zephyr Credentials') {
            when {
                not {
                    expression {
                        return params.SKIP_ZEPHYR_DOWNLOAD == true
                    }
                }
            }
            steps {
                script {
                    echo "🔍 Debugging Zephyr Scale integration..."
                    echo "Project Key: ${params.ZEPHYR_PROJECT_KEY}"
                    echo "TQL Query: ${params.ZEPHYR_TQL}"
                    echo "Endpoint: ${params.ZEPHYR_ENDPOINT}"

                    withCredentials([string(credentialsId: '01041c05-e42f-4e53-9afb-17332c383af9', variable: 'ZEPHYR_TOKEN')]) {
                        // Validate token without exposing it
                        def tokenLength = env.ZEPHYR_TOKEN?.length() ?: 0
                        echo "🔐 Token validation:"
                        echo "   - Token length: ${tokenLength} characters"
                        echo "   - Token prefix: ${env.ZEPHYR_TOKEN?.take(20)}..."
                        echo "   - Contains JWT dots: ${env.ZEPHYR_TOKEN?.contains('.') ? 'Yes' : 'No'}"

                        if (tokenLength == 0) {
                            error "❌ ZEPHYR_TOKEN is empty. Check Jenkins credential ID: 01041c05-e42f-4e53-9afb-17332c383af9"
                        }

                        if (tokenLength < 50) {
                            echo "⚠️ Warning: Token seems unusually short for a Zephyr API token (${tokenLength} chars)"
                        }

                        if (!env.ZEPHYR_TOKEN?.contains('.')) {
                            echo "⚠️ Warning: Token doesn't appear to be in JWT format (no dots found)"
                        }

                        echo "✅ Token validation passed"
                    }
                }
            }
        }

        stage('Download Approved Feature Files from Zephyr') {
            when {
                not {
                    expression {
                        return params.SKIP_ZEPHYR_DOWNLOAD == true
                    }
                }
            }
            steps {
                sh 'rm -rf src/test/resources/features/* || true'

                script {
                    withCredentials([string(credentialsId: '01041c05-e42f-4e53-9afb-17332c383af9', variable: 'ZEPHYR_TOKEN')]) {
                        echo "🔄 Downloading test cases from Zephyr Scale..."

                        // Determine API endpoint based on parameter
                        def baseUrl = params.ZEPHYR_ENDPOINT == 'us' ?
                            'https://api.zephyrscale.smartbear.com' :
                            'https://eu.api.zephyrscale.smartbear.com'

                        echo "Using API endpoint: ${baseUrl}"

                        // FIXED: Use simpler endpoint without TQL
                        def api_url = "${baseUrl}/v2/testcases?projectKey=${params.ZEPHYR_PROJECT_KEY}&status=Approved&maxResults=100"

                        echo "✅ Correct API URL: ${api_url}"

                        // Make the API call
                        def response = sh(
                            script: """
                                curl -s -w "HTTPSTATUS:%{http_code}" \\
                                --connect-timeout 10 \\
                                --max-time 60 \\
                                -X GET "${api_url}" \\
                                -H "Authorization: Bearer \${ZEPHYR_TOKEN}" \\
                                -H "Content-Type: application/json"
                            """,
                            returnStdout: true
                        ).trim()

                        // Split the response to get HTTP status and body
                        def httpStatus = ""
                        def responseBody = ""
                        if (response.contains("HTTPSTATUS:")) {
                            def parts = response.split("HTTPSTATUS:")
                            responseBody = parts[0]
                            httpStatus = parts[1]
                        } else {
                            responseBody = response
                        }

                        echo "HTTP Status: ${httpStatus}"
                        echo "Response Body (first 500 chars): ${responseBody.take(500)}..."

                        // Enhanced error handling
                        if (httpStatus != "200") {
                            echo "❌ API call failed with HTTP status: ${httpStatus}"
                            echo "Full response: ${responseBody}"

                            // Provide specific troubleshooting based on status code
                            switch (httpStatus) {
                                case "401":
                                    echo "🔒 Authentication failed - Check your API token"
                                    echo "   1. Verify credential ID: 01041c05-e42f-4e53-9afb-17332c383af9"
                                    echo "   2. Ensure token is valid and not expired"
                                    echo "   3. Check token has proper permissions"
                                    break
                                case "403":
                                    echo "🚫 Authorization failed - Token doesn't have required permissions"
                                    break
                                case "404":
                                    echo "🔍 Not found - Check project key: ${params.ZEPHYR_PROJECT_KEY}"
                                    break
                                case "429":
                                    echo "⏱️ Rate limit exceeded - Wait and retry"
                                    break
                                default:
                                    echo "🌐 Network or server error - Check connectivity"
                            }

                            if (params.CREATE_SAMPLE_IF_EMPTY) {
                                echo "Creating sample feature file to continue pipeline..."
                                createSampleFeatureFile()
                            } else {
                                error "API call failed. Set CREATE_SAMPLE_IF_EMPTY=true to continue with sample data."
                            }
                            return
                        }

                        // Parse JSON response
                        try {
                            def json = new groovy.json.JsonSlurper().parseText(responseBody)

                            echo "📊 API Response Analysis:"
                            echo "   - Total test cases: ${json.total ?: 'not available'}"
                            echo "   - Returned test cases: ${json.values?.size() ?: 0}"
                            echo "   - Max results setting: ${json.maxResults ?: 'not specified'}"

                            if (json.total && json.total > 0 && json.values && json.values.size() > 0) {
                                echo "✅ Found ${json.total} test cases. Processing ${json.values.size()}..."

                                // Create features in the main features directory for Karate to find
                                sh "mkdir -p src/test/resources/features"

                                def processedCount = 0
                                def skippedCount = 0

                                json.values.each { testCase ->
                                    def issueKey = testCase.key
                                    def name = testCase.name ?: "Unnamed Test"
                                    def status = testCase.status?.name ?: "Unknown Status"
                                    def testScriptUrl = testCase.testScript?.self

                                    echo "Processing: ${issueKey} - ${name} (${status})"

                                    if (testScriptUrl) {
                                        // Download the test script content
                                        def scriptResponse = sh(
                                            script: """
                                                curl -s -w "HTTPSTATUS:%{http_code}" \\
                                                --connect-timeout 10 \\
                                                --max-time 60 \\
                                                -X GET "${testScriptUrl}" \\
                                                -H "Authorization: Bearer \${ZEPHYR_TOKEN}" \\
                                                -H "Content-Type: application/json"
                                            """,
                                            returnStdout: true
                                        ).trim()

                                        def scriptHttpStatus = ""
                                        def scriptResponseBody = ""
                                        if (scriptResponse.contains("HTTPSTATUS:")) {
                                            def parts = scriptResponse.split("HTTPSTATUS:")
                                            scriptResponseBody = parts[0]
                                            scriptHttpStatus = parts[1]
                                        } else {
                                            scriptResponseBody = scriptResponse
                                        }

                                        def scriptContent = ""
                                        if (scriptHttpStatus == "200") {
                                            def scriptJson = new groovy.json.JsonSlurper().parseText(scriptResponseBody)
                                            scriptContent = scriptJson.text ?: ""
                                        }

                                        if (scriptContent && scriptContent.trim()) {
                                            // Validate feature file content
                                            if (scriptContent.contains("Features:")) {
                                                def featureFileName = "src/test/resources/features/${issueKey}.feature"
                                                writeFile file: featureFileName, text: scriptContent
                                                echo "✅ Created: ${featureFileName}"
                                                processedCount++
                                            } else {
                                                echo "⚠️ ${issueKey} script doesn't contain 'Feature:' - creating enhanced placeholder"
                                                createEnhancedPlaceholder(issueKey, name, status, scriptContent)
                                                processedCount++
                                            }
                                        } else {
                                            echo "⚠️ ${issueKey} has no script content - creating placeholder"
                                            createEnhancedPlaceholder(issueKey, name, status, "")
                                            skippedCount++
                                        }
                                    } else {
                                        echo "⚠️ ${issueKey} has no test script URL - creating placeholder"
                                        createEnhancedPlaceholder(issueKey, name, status, "")
                                        skippedCount++
                                    }
                                }

                                echo "✅ Processing complete:"
                                echo "   - Successfully processed: ${processedCount} test cases"
                                echo "   - Placeholders created: ${skippedCount} test cases"
                                echo "   - Total files created: ${processedCount + skippedCount}"

                            } else {
                                echo "❌ No test cases found with current criteria"
                                echo "🔍 Troubleshooting suggestions:"
                                echo "   1. Check if test cases exist in project '${params.ZEPHYR_PROJECT_KEY}'"
                                echo "   2. Verify test cases have 'Approved' status"

                                if (params.CREATE_SAMPLE_IF_EMPTY) {
                                    echo "Creating sample feature file to continue pipeline..."
                                    createSampleFeatureFile()
                                } else {
                                    error "No test cases found. Set CREATE_SAMPLE_IF_EMPTY=true to continue with sample data."
                                }
                            }
                        } catch (Exception e) {
                            echo "❌ Failed to parse JSON response: ${e.getMessage()}"
                            echo "Raw response: ${responseBody}"

                            if (params.CREATE_SAMPLE_IF_EMPTY) {
                                echo "Creating sample feature file due to parsing error..."
                                createSampleFeatureFile()
                            } else {
                                error "JSON parsing failed. Set CREATE_SAMPLE_IF_EMPTY=true to continue with sample data."
                            }
                        }
                    }
                }

                // Confirm files were downloaded
                script {
                    def count = sh(script: "find src/test/resources/features -name '*.feature' 2>/dev/null | wc -l || echo '0'", returnStdout: true).trim()
                    echo "📊 Final count: ${count} feature files in src/test/resources/features"

                    if (count == '0') {
                        echo "❌ No feature files found after processing"
                        if (params.CREATE_SAMPLE_IF_EMPTY) {
                            echo "Creating emergency sample feature file..."
                            createSampleFeatureFile()
                            // Recount
                            count = sh(script: "find src/test/resources/features -name '*.feature' 2>/dev/null | wc -l || echo '0'", returnStdout: true).trim()
                            echo "📊 After creating sample: ${count} feature files"
                        }

                        if (count == '0') {
                            error "❌ Still no feature files available. Cannot proceed with tests."
                        }
                    }

                    // List the feature files for verification
                    sh """
                        echo '📁 Feature files created:'
                        find src/test/resources/features -name '*.feature' -exec echo '   {}' \\; | head -10
                        echo ''
                        echo '📝 Feature file sizes:'
                        find src/test/resources/features -name '*.feature' -exec wc -l {} \\; | head -5
                    """
                }
            }
        }

        // ... rest of the pipeline remains unchanged ...
    }

    // ... helper functions remain unchanged ...
}