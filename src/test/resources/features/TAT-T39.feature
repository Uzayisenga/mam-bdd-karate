Feature: MMPI-T45:Mileage Pooling
    @TestCaseKey=TAT-T39
        
        Scenario Outline: MMPI-T45: Validate the mileage pooling
            Given '<user-type>' is enrolled via API
              | tenantid   |
              | <tenantid> |
            When user logs in using '<login type>''<PIN/PW>' in the login component appropriately in the '<user-type>' MAM page
            Then mam member page is displayed
            And User clicks on My account button
            And User clicks on Mileage Pooling
            And User clicks on Start Mileage Pooling
            Given '<user-type>' is enrolled via API
              | tenantid   |
              | <tenantid> |
            And User enter service card number in mileage pooling
            And User Click on Next button
            And User select the checkbox and clicks on Next button
            And User Verify you will soon be able to start
            And User clicks on Understood button
            And User logout the account
            And User Login into new account
            And User clicks on My account button
            And User clicks on Mileage Pooling
            And User accepts the Invitation
            And User select the checkbox and accept invitation
            And User clicks on OK button
        #    And User verify text "Congratulations! You are now the member of a pool."
        
            Examples:
              | user-type    | login type | PIN/PW | tenantid |
              | TravelID FFP | Email      | PW     | MMG      |