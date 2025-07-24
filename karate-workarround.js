function fn() {
  var FileUtils = Java.type('org.apache.commons.io.FileUtils');
  var File = Java.type('java.io.File');

  var config = {
    baseUrl: 'https://api.zephyrscale.smartbear.com/v2',
    jiraEmail: 'testsolutions72@gmail.com',
    apiToken: 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjb250ZXh0Ijp7ImJhc2VVcmwiOiJodHRwczovL21pbGVhbmQuYXRsYXNzaWFuLm5ldCIsInVzZXIiOnsiYWNjb3VudElkIjoiNzEyMDIwOjY5OTJlMTEyLTc4N2QtNDNiNy04MzlkLTFhNmZiNGE4MTYwOCIsInRva2VuSWQiOiIwMTA0MWMwNS1lNDJmLTRlNTMtOWFmYi0xNzMzMmMzODNhZjkifX0sImlzcyI6ImNvbS5rYW5vYWgudGVzdC1tYW5hZ2VyIiwic3ViIjoiMTM2NjU0OTItZjA0OS0zN2RkLWExMmEtNzFmZTdjOTM4MjM0IiwiZXhwIjoxNzg0NjIzNTI3LCJpYXQiOjE3NTMwODc1Mjd9.Xi8jWOdL54fTQRGGOFSBAZD_3S6a3s6bEXS_daDChhw',
    projectKey: 'SCRUM',
    outputDir: 'src/test/resources/features'  // local output folder
  };

  var auth = config.jiraEmail + ':' + config.apiToken;
  var encodedAuth = java.util.Base64.getEncoder().encodeToString(auth.getBytes());

  var request = karate.callSingle({
    url: config.baseUrl + '/testcases',
    method: 'GET',
    headers: {
      Authorization: 'Basic ' + encodedAuth
    },
    params: {
      projectKey: config.projectKey,
      query: 'status = "Approved" AND scriptType = "Gherkin"',
      maxResults: 100
    }
  });

  var testCases = request.response && request.response.items ? request.response.items : [];

  karate.log('Found test cases:', testCases.length);

  for (var i = 0; i < testCases.length; i++) {
    var tc = testCases[i];
    var name = tc.name.replace(/\s+/g, '_').replace(/[^\w]/g, '');
    var gherkin = tc.script || '';
    var featureFile = new File(config.outputDir + '/' + name + '.feature');
    FileUtils.writeStringToFile(featureFile, gherkin, 'UTF-8');
  }

  return config;
}
