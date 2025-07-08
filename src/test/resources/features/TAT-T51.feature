Feature: MMPI-T3345-TC05_Verify behavior of Login URL parameter_target state
    @TestCaseKey=TAT-T51
        
        Scenario Outline: Verify user is successfully logged into MAM pages for various target states
                  Given Legacy FFP user is enrolled via API
                  And user is in MAM login page
                  When user changes the target state to '<target-state>' in the login '<URL>' of the MAM page
                  And user is logs in using enrolled customer credentials
                  Then mam member page is displayed
        
               Examples:
                  | target-state  | URL                                                                                                                                                                                                                                                                                                                                                                                                                               |
                  | AUTHENTICATED | https://account-uat1.miles-and-more.com/web/de/en/login.html?client_id=vjLGLNf95WRAvFsZ0aJTfa4qgpTHSL98&target_state=AUTHENTICATED&target_url=https://consent-acc.test-msp.miles-and-more.com/&response_type=code&redirect_uri=https%3A%2F%2Fwww-uat1.miles-and-more.com&scope=AUTHENTICATED%20IDENTIFIED%20urn%3Amilesandmore%3Atech%3Abackground%3Av1%3Aactive&state=null&principal_type=SERVICE_CARD_NUMBER&reduced_state=NONE |
                  | IDENTIFIED    | https://account-uat1.miles-and-more.com/web/de/en/login.html?client_id=vjLGLNf95WRAvFsZ0aJTfa4qgpTHSL98&target_state=IDENTIFIED&target_url=https://consent-acc.test-msp.miles-and-more.com/&response_type=code&redirect_uri=https%3A%2F%2Fwww-uat1.miles-and-more.com&scope=AUTHENTICATED%20IDENTIFIED%20urn%3Amilesandmore%3Atech%3Abackground%3Av1%3Aactive&state=null&principal_type=SERVICE_CARD_NUMBER&reduced_state=NONE    |
                  | DEFAULT       | https://account-uat1.miles-and-more.com/web/de/en/login.html?client_id=vjLGLNf95WRAvFsZ0aJTfa4qgpTHSL98&target_state=DEFAULT&target_url=https://consent-acc.test-msp.miles-and-more.com/&response_type=code&redirect_uri=https%3A%2F%2Fwww-uat1.miles-and-more.com&scope=AUTHENTICATED%20IDENTIFIED%20urn%3Amilesandmore%3Atech%3Abackground%3Av1%3Aactive&state=null&principal_type=SERVICE_CARD_NUMBER&reduced_state=NONE       |