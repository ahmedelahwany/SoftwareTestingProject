# new feature
# Tags: optional

Feature: Verify creating account (Registeration) feature with correct details

  Scenario: A scenario
    Given The AutomationPractice site is open
    And User Navigate to the login page and submit an email to create account
    When The random user details filled in the registeration page
    Then verify Created user 'John Doe' on the home page
    And Sign out