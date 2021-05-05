# new feature
# Tags: optional

Feature: Register with some missing data fields
  Background:
    Given The AutomationPractice site is open
    And User Navigate to the login page and submit an email to create account

  Scenario Outline:
    Given The '<field>' is not filled and the rest fields are filled with random registration data
    Then The '<msg>' message is shown
    Examples:
      | field     |  msg                             |
      | firstName | firstname is required.           |
      | lastName  | lastname is required.           |
      | password  | passwd is required.     |
      | address   | address1 is required.     |