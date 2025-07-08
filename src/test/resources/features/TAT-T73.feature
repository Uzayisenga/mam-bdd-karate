Feature: MMPI-T4829- MAMCOM User Enrollment & PIN request (geklont)
    @TestCaseKey=TAT-T73
         Scenario Outline: Verify whether user is able to do enrollment and request PIN successfully_MAM
            And User launch MAM page
            And User clicks on Login button
            And User clicks on Register for Travel ID
            When user enters the "emailaddress" and "Test@1234" in the Registration Step
            And user enters all the mandatory personal details with Country as '<COR>''<zipCode>',Date of birth as '<DOB>' in the Personal details step
            And user selects Service card as '<enrolment_service_card>' in the Enrolment Service card step
            And user selects the MMG permission as '<allInOnePermissions>' appropriately in the Communication step
            And user clicks on Confirm and Continue button
            Then enrolment confirmation screen is displayed
            And user is successfully enrolled upon launching the activation link from the 15 below mail '<tenantid>'
            And User Login into account
        #    And User get service card number for tenant
        #    And User launch the forgot pin URL '<forgotURL>' for MAM
        #    And User enter Service card number for forgot PIN
        #    And User clicks on Send Link button
        #    And User launch 15 below mail and enter email address
        ##    And User launch yopmail and reset PIN
        #    And User changes the PIN for MAM
        #    And User clicks on Login button in change PIN page for MAM
        #    And mam member page is displayed
        
            Examples:
              | enrolment_service_card | COR          | DOB        | allInOnePermissions | zipCode | forgotURL                                                                                                                                                         | tenantid |
              | Lufthansa              | Germany (DE) | 26-07-1996 | true                | 60549   | https://account-uat1.miles-and-more.com/web/de/en/pin-password-forgotten.html?redirect_uri=https://www-uat1.miles-and-more.com&principal_type=SERVICE_CARD_NUMBER | MMG Web  |