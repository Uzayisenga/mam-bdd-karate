Feature: MMPI-T4830-Verify whether user is able to do enrollment and request PIN successfully_TENANTS (geklont)
    @TestCaseKey=TAT-T74
        Scenario Outline: Verify whether user is able to do enrollment and request PIN successfully_TENANTS
            Given user is in the flight search form page in '<tenant>'
            When user enters the "emailaddress" and "Test@1234" in the Registration Step
            And user chooses Activate Miles & More in Activation Miles & More Step
            And user enters '<First Name>''<Last Name>''<DOB DD-MM-YYYY>''<Country>''<street>''<postcode>''<city>''<Telephone number (Prefix, Area code, NO>' in the respective fields
            And user clicks continue on component enrolment personal details step
            And user clicks on Yes, I grant my permission checkbox
            When user clicks confirm and continue on component enrolment communication step
            Then enrolment confirmation text contains email address
            And user is successfully enrolled upon launching the activation link from the 15 below mail '<tenantid>'
            And User clicks on Login button after enrollment
            And User click on Login button on Tenant
            And User get service card number for tenant
            And User launch the forgot pin URL '<forgotURL>'
            And User enter Service card number for forgot PIN
            And User clicks on Send Link button
            And User launch yopmail and reset PIN
            And User changes the PIN
        #    And User clicks on Login button in change PIN page
        #    And User clicks on profile button on Tenant
        #    And User clicks Logout button on Tenant
        
        
            Examples:
              | tenant                                      | target-state | tenantid | allInOnePermissions | enrollmentSourceCode | behaviouralPermission | personalDataUsageAllowed | First Name | Last Name | DOB DD-MM-YYYY | Country      | street       | postcode | city     | Telephone number (Prefix, Area code, NO | forgotURL                                                                                                                                                     |
        #      | https://qa-www.lufthansa.com/ro/en/homepage        | DEFAULT      | LH Web   | true                | 0LO22                | true                  | true                     | Test       | User      | 01-01-1990     | Poland (PL)  | Teststreet 2 | 12-345   | TestCity | (+49),123, 1234555                      | https://lufthansa-uat1.miles-and-more.com/web/row/en/pin-password-forgotten.html?redirect_uri=https://qa-www.lufthansa.com&principal_type=SERVICE_CARD_NUMBER               |
              | https://qa-www.swiss.com/ro/en/homepage     | DEFAULT      | LX Web   | true                | 0OU22                | true                  | true                     | Test       | User      | 01-01-1990     | Croatia (HR) | Teststreet 2 | 89076    | TestCity | (+49),123, 1234555                      | https://swiss-uat1.miles-and-more.com/web/row/en/pin-password-forgotten.html?redirect_uri=https://qa-www.swiss.com&principal_type=SERVICE_CARD_NUMBER         |
        #      | https://qa-www.austrian.com/ro/en/homepage  | DEFAULT      | OS Web   | true                | 0LO22                | true                  | true                     | Test       | User      | 01-01-1990     | Poland (PL)  | Teststreet 2 | 12-345   | TestCity | (+49),123, 1234555                      | https://austrian-uat1.miles-and-more.com/web/row/en/pin-password-forgotten.html?redirect_uri=https://qa-www.austrian.com&principal_type=SERVICE_CARD_NUMBER   |
        #      | https://qa-www.brusselsairlines.com/ro/en/homepage | DEFAULT      | SN Web   | true                | 0LO22                | true                  | true                     | Test       | User      | 01-01-1990     | Poland (PL)  | Teststreet 2 | 12-345   | TestCity | (+49),123, 1234555                      |https://brusselsairlines-uat1.miles-and-more.com/web/row/en/pin-password-forgotten.html?redirect_uri=https://qa-www.brusselsairlines.com&principal_type=SERVICE_CARD_NUMBER|