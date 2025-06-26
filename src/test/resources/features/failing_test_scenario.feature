#@failingTest
#Feature: Deliberate Failing Scenario
#
#  Scenario: Verify that failing scenario attaches screenshot and logs
#    Given the user is on "https://www-uat1.miles-and-more.com/de/en/program/partners/silkair.html"
#    Then the system should report a deliberate failure

@failingTest
Feature: Deliberate Failing Scenario

  Scenario: Verify that failing scenario attaches screenshot and logs
    Given the user is on "https://www-uat1.miles-and-more.com/de/en/program/partners/silkair.html"
    Then the system should report a deliberate failure
