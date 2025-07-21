@echo off
setlocal enabledelayedexpansion

echo Uploading Karate JUnit results to Zephyr Scale Cloud...

REM Look for the JUnit XML
for %%f in (target\surefire-reports\TEST-*.xml) do (
    set REPORT_PATH=%%f
)

if defined REPORT_PATH (
    echo Found test report: !REPORT_PATH!

    curl --location --request POST ^
      "https://eu.api.zephyrscale.smartbear.com/v2/automations/executions/junit?projectKey=SCRUM" ^
      --header "Authorization: Bearer %ZEPHYR_TOKEN%" ^
      --header "Content-Type: multipart/form-data" ^
      --form "file=@!REPORT_PATH!"
) else (
    echo ERROR: No test report found in target\surefire-reports\
    exit /b 1
)
