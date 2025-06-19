Feature: Travel ID Page Validations

  Scenario: Travel ID Login and back navigation
    Given user is in "https://www-uat1.miles-and-more.com/de/en/program/partners/silkair.html" page
    And user clicks login in travel id login trigger component
    And user redirects to the travel id login form
    When user clicks on back link of travel id login form
    Then user is redirected back to prehome page "https://www-uat1.miles-and-more.com/row/en/program/partners/silkair.html"

  Scenario: Travel ID Enrolment form redirection
    Given user is in "https://www-uat1.miles-and-more.com/de/en/program/partners/silkair.html" page
    When user clicks enrolment link in travel id login trigger component
    Then user redirects to the travel id enrolment form

  Scenario: Travel ID Enrolment form back link
    Given user is in "https://www-uat1.miles-and-more.com/de/en/program/partners/silkair.html" page
    And user clicks enrolment link in travel id login trigger component
    And user redirects to the travel id enrolment form
    And user clicks on back link of enrolment form