Feature: MMPI-T3366-TC06_Error validation for Login page from MAM page (geklont)
    @TestCaseKey=TAT-T61
        Scenario Outline: Verify appropriate error messages for invalid login credentials in MAM
          Given user is in MAM login page
          When user enters "<login data>" in the "<login type>" field of the login component
          And user attempts to log in with password "<PIN/PW>" if applicable
          Then "<login type>" error is displayed as "<error message>"
        
        Examples:
          | login type | login data          | PIN/PW   | error message                                                                                                  |
          | Email      | test                |          | Please enter your email address in the following format: email@address.com                                     |
          | Email      | test123.com         |          | Please enter your email address in the following format: email@address.com                                     |
          | Email      | test@123            |          | Please enter your email address in the following format: email@address.com                                     |
          | SCN        | 99932               |          | Your service card number consists of 15 digits.                                                                |
          | SCN        | 9999323237asd       |          | The service card number entered contains invalid characters. Please use digits only.                           |
          | SCN        | 213232322333333     |          | The service card number begins with 9999, 9920, 9922, 2220 or 3330.                                            |
          | Username   |                     |          | Please enter your Travel ID (email address) or service card number.                                            |
          | SCN        | 992005087436084     | 12345    | Wrong username or password                                                                                     |
          | SCN        | 992005087436084     |          | Please enter your PIN.                                                                                         |
          | SCN        | 992005087436084     | 99a      | Only digits (0-9) are permitted.                                                                               |
          | Username   | gtest31             |          | Please enter your password.                                                                                    |
          | TravelID   | TravelID_basic_user | Test@123 | Login only possible for Miles & More participants. If you have any questions, please contact the Miles & More Service Team under Help & Contact. |