Feature: MMPI-T47-Validate the logged in user (geklont)
    @TestCaseKey=TAT-T72
        Scenario Outline: Verify update Email Address, Phone number,Additional phone number, Address, COR in Personal Information Form for 2FA enabled user
            Given '<user-type>' is enrolled via API
              | tenantid   |
              | <tenantid> |
            And user activate the mfa
            When user logs in using '<login type>''<PIN/PW>' in the login component appropriately in the '<user-type>' MAM page
            And user enter MFA code in the after login screen
            And user navigates to My Profile page>Personal Information Overview component
            When user edit the '<attribute>'
            Then User navigates to My Profile page and verify personal changes are updated
            And  User clicks on Travel preference edit button
            Then User enters departure airport
            Then User clicks on Save changes in Travel preferences
            Then User navigates to My Profile page and verify personal changes are updated
            Then User navigates to My Profile page and verify travel preferences changes are updated
            And User clicks on Personalised offers and communications edit button
            Then User disable Personalised communications under Miles & More communications
            Then User clicks on Save changes in Personalised offers and communications
            Then User navigates to My Profile page and verify Personalised offers and communications changes are updated
        
            Examples:
              | user-type    | attribute                                                                                  | tenantid |login type |PIN/PW |
              | TravelID FFP | Address fields - Street and house number, Town/city, Additional line of address (optional) | MMG      |Email      |PW     |