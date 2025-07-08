Feature: MMPI-T3325-TC06_UI validation in TravelID Enrolment component_MAM tenant (geklont)
    @TestCaseKey=TAT-T57
         Scenario Outline: Verify the fly out validation for pin/password if invalid pin/password is entered in enrolment component
            Given user navigates to the enrolment component
            When user enters email address 'Test@yopmail.com' in  enrolment component
            Then user enters the '<invalid1>' '<invalid2>' '<invalid3>' '<invalid4>' '<invalid5>' '<invalid6>' '<invalid7>' in password field
            When user enters email address 'Test@yopmail.com' in  enrolment component
            Then user enters the 'Test@123' in password field flyout validation is not displayed
            Examples:
             | invalid1 | invalid2 | invalid3 | invalid4 | invalid5 | invalid6  | invalid7 |
              | Test@12  | Test@12  | TEST@123 | Test@ONE | TEST1123 | Test@123} | test@123 |