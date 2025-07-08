Feature: MMPI-T3373-TC01_Verify TravelID Enrolment for COR with Choice Brands on MAM tenant
    @TestCaseKey=TAT-T46
        
        Scenario Outline: Verify TravelID Enrolment for COR with Choice Brands on MAM tenant
          Given user is in the TravelID Enrolment page in MAM
          When user enters the "<email>" and "<password>" in the Registration Step
          And user enters all the mandatory personal details with Country as "<COR>", Zip Code as "<zipCode>", and Date of Birth as "<DOB>" in the Personal details step
          And user selects Service card as "<enrolment_service_card>" in the Enrolment Service card step
          And user selects the MMG permission as "<allInOnePermissions>" appropriately in the Communication step
          And user clicks on Confirm and Continue button
          Then enrolment confirmation screen is displayed
          And user is successfully enrolled upon launching the activation link from the mail
          And user is successfully enrolled upon launching the activation link from the 15 below mail "<tenantid>"
          And "<user details>" are retrieved as provided during registration from SAMBA API services with:
            | enrollmentSourceCode        | <enrollmentSourceCode>         |
            | zipCode                     | <zipCode>                      |
            | allInOnePermissions         | <allInOnePermissions>          |
            | personalDataUsageAllowed    | <personalDataUsageAllowed>     |
            | COR                         | <COR>                          |
        
        Examples:
          | email          | password  | enrolment_service_card | COR              | DOB        | allInOnePermissions | enrollmentSourceCode | zipCode | behaviouralPermission | personalDataUsageAllowed | tenantid |
          | user1@test.com | Test@1234 | Lufthansa              | Germany (DE)     | 26-07-1996 | true                | 0LH22                | 60549   | true                  | true                     | MMG Web  |
          | user2@test.com | Test@1234 | Swiss                  | Switzerland (CH) | 27-07-1997 | false               | 0LX22                | 6054    | false                 | false                    | MMG Web  |
          | user3@test.com | Test@1234 | Austrian               | Austria (AT)     | 28-07-1998 | true                | 0OS22                | 6054    | true                  | true                     | MMG Web  |
          | user4@test.com | Test@1234 | Eurowings              | India (IN)       | 23-07-2009 | false               | 0EW22                | 123456  | false                 | false                    | MMG Web  |
          | user5@test.com | Test@1234 | Brussels               | USA (US)         | 26-07-2010 | true                | 0SN22                | 60549   | true                  | true                     | MMG Web  |