Feature: Login (Blocked)
    @TestCaseKey=TAT-T29
    Scenario: Login (Blocked)
        
        Given the wrong user is on the login page
        When they enter valid credentials
        Then they should be redirected to the dashboard