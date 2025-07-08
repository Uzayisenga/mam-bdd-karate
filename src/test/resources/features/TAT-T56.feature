Feature: Login and logout with username_servicecardnumber_email address UAT1 (geklont)
    @TestCaseKey=TAT-T56
    Scenario: Login and logout with username_servicecardnumber_email address UAT1 (geklont)
        
        
            And User launch MAM page
            And User clicks on Login button
            And User enter email address & password
              | Email Address      | Password |
              | dom426@yopmail.com | Test@123 |
            And clicks on Login button
            And User clicks on Logout button
        
            And User launch MAM page
            And User clicks on Login button
            And User enter SCN & PIN
              | SCN             | PIN   |
              | 992000253610547 | 64334 |
            And clicks on Login button for SCN
            And User clicks on Logout button
        
            And User launch MAM page
            And User clicks on Login button
            And User enter Username & Password
              | Username | Password |
              | Dom416   | Test@123 |
            And clicks on Login button for Username
            And User clicks on Logout button