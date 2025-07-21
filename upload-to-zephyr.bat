@echo off
setlocal enabledelayedexpansion

echo Uploading report to Zephyr...

REM Look for the JUnit XML
for %%f in (target\surefire-reports\TEST-*.xml) do (
    set REPORT_PATH=%%f
)

if defined REPORT_PATH (
    echo Found test report: !REPORT_PATH!
    curl --location --request POST ^
      "https://mileand.atlassian.net/projects/SCRUM?selectedItem=com.atlassian.plugins.atlassian-connect-plugin:com.kanoah.test-manager__main-project-page#!/v2/testCases" ^
      --header "Authorization: Bearer %ZEPHYR_TOKEN%" ^
      --form "file=@!REPORT_PATH!" ^
      --form "autoCreateTestCases=true"
) else (
    echo ERROR: No test report found in target\surefire-reports\
    exit /b 1
)