
Feature: Deliberate Failing Scenario


  Scenario: Verify that failing scenario attaches screenshot and logs
    Given the user is on "https://www.miles-and-more.com/row/de.html"
    Then the system should report a deliberate failure
