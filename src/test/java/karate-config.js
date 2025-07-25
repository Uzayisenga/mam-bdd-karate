// src/test/java/karate-config.js OR src/test/resources/karate-config.js
function fn() {
  var config = {
    baseUrl: 'https://eu.api.zephyrscale.smartbear.com/v2', // Hardcoded for testing loading
    zephyrToken: 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjb250ZXh0Ijp7ImJhc2VVcmwiOiJodHRwczovL21pbGVhbmQuYXRsYXNzaWFuLm5ldCIsInVzZXIiOnsiYWNjb3VudElkIjoiNzEyMDIwOjY5OTJlMTEyLTc4N2QtNDNiNy04MzlkLTFhNmZiNGE4MTYwOCIsInRva2VuSWQiOiIwMTA0MWMwNS1lNDJmLTRlNTMtOWFmYi0xNzMzMmMzODNhZjkifX0sImlzcyI6ImNvbS5rYW5vYWgudGVzdC1tYW5hZ2VyIiwic3ViIjoiMTM2NjU0OTItZjA0OS0zN2RkLWExMmEtNzFmZTdjOTM4MjM0IiwiZXhwIjoxNzg0NjIzNTI3LCJpYXQiOjE3NTMwODc1Mjd9.Xi8jWOdL54fTQRGGOFSBAZD_3S6a3s6bEXS_daDChhw', // Hardcoded your valid JWT for testing loading
    projectKey: 'SCRUM',
    approvalStatus: 'Approved'
  };

  config.authHeader = { Authorization: 'Bearer ' + config.zephyrToken };

  karate.log('*** KARATE-CONFIG.JS LOADED! Final config object:', config); // CRITICAL LOG
  return config;
}