Feature: MMPI-T3379-TC02_Verify TravelID Enrolment for Homemarket country on MAM tenant
    @TestCaseKey=TAT-T47
        
        Scenario Outline: Verify TravelID Enrolment for Homemarket country on MAM tenant
            Given user is in the TravelID Enrolment page in MAM
            When user enters the "emailaddress" and "Test@1234" in the Registration Step
            And user enters all the mandatory personal details with Country as '<COR>''<zipCode>',Date of birth as '<DOB>' in the Personal details step
            And user selects the MMG permission as '<allInOnePermissions>' appropriately in the Communication step
            And user clicks on Confirm and Continue button
            Then enrolment confirmation screen is displayed
        #    And user is successfully enrolled upon launching the activation link from the mail
            And user is successfully enrolled upon launching the activation link from the 15 below mail '<tenantid>'
        #    And <user details> are retrieved as provided during registration from SAMBA API services for non chioce brand country'<enrollmentSourceCode>''<zipCode>''<allInOnePermissions>''<personalDataUsageAllowed>''<COR>'
        
            Examples:
              | COR          | DOB        | allInOnePermissions | enrollmentSourceCode | zipCode | behaviouralPermission | personalDataUsageAllowed |tenantid|
              | Poland (PL)  | 26-07-1996 | true                | 0LO22                | 12-123  | true                  | true                     |MMG Web|
              | Poland (PL)  | 27-07-1997 | false               | 0LO22                | 12-123  | false                 | false                    |MMG Web|
              | Croatia (HR) | 28-07-1998 | true                | 0OU22                | 12123   | true                  | true                     |MMG Web|