Feature: MMPI-T3343-TC01_Verify user is able to login to MAM tenant_Successful (geklont)
    @TestCaseKey=TAT-T58
        
        Scenario Outline: Verify user is successfully logged into MAM page
            Given '<user-type>' is enrolled via API
              | tenantid   |
              | <tenantid> |
            When user logs in using '<login type>''<PIN/PW>' in the login component appropriately in the '<user-type>' MAM page
            Then mam member page is displayed
        #         And user navigate to flight search screen
        
        
            Examples:
              | user-type    | login type | PIN/PW | x-api-key                        | redirect_uri                        | state       | tenantid |
              | TravelID FFP | Email      | PW     | vjLGLNf95WRAvFsZ0aJTfa4qgpTHSL98 | https://www-uat1.miles-and-more.com | /de/en.html | MMG      |
        #      | Legacy FFP   | Username   | PW     | vjLGLNf95WRAvFsZ0aJTfa4qgpTHSL98 | https://www-uat1.miles-and-more.com | /de/en.html | MMG      |
        #      | Legacy FFP   | SCN        | PIN    | vjLGLNf95WRAvFsZ0aJTfa4qgpTHSL98 | https://www-uat1.miles-and-more.com | /de/en.html | MMG      |