Feature: MMPI-T3527_TC-08-Verify user redirect to Travel ID Login page from Travel ID Login Trigger component
    @TestCaseKey=TAT-T54
        
        Scenario Outline: Verify Travel ID Login Trigger Component functionality for login and enrolment
          Given "<user-type>" is enrolled via API if applicable
            | tenantid   |
            | <tenantid> |
          And user is in "<source page>" page
          And user clicks "<entry action>" in travel id login trigger component
          And user is redirected to "<target page>"
          When user performs action "<user action>" with "<login type>" and "<PIN/PW>" if applicable
          Then user is redirected back to "<expected redirection>"
        
        Examples:
        | user-type       | login type | PIN/PW | tenantid | source page                                                                 | entry action | target page                                      | user action             | expected redirection                                                             |
        | TravelID FFP    | Email      | PW     | MMG      | https://www-uat1.miles-and-more.com/de/en/program/partners/silkair.html    | login        | travel id login form                            | login                   | https://www-uat1.miles-and-more.com/row/en/program/partners/silkair.html       |
        | Guest           | -          | -      | -        | https://www-uat1.miles-and-more.com/de/en/program/partners/silkair.html    | login        | travel id login form                            | click back link         | https://www-uat1.miles-and-more.com/row/en/program/partners/silkair.html       |
        | Guest           | -          | -      | -        | https://www-uat1.miles-and-more.com/de/en/program/partners/silkair.html    | enrolment    | travel id enrolment form                        | -                      | travel id enrolment form                                                         |
        | Guest           | -          | -      | -        | https://www-uat1.miles-and-more.com/de/en/program/partners/silkair.html    | enrolment    | travel id enrolment form                        | click back link         | https://www-uat1.miles-and-more.com/row/en/program/partners/silkair.html       |