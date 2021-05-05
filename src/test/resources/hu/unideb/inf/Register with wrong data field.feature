# new feature
# Tags: optional

Feature: Register with some wrong data fields
  Background:
    Given The AutomationPractice site is open
    And User Navigate to the login page and submit an email to create account

  Scenario Outline:
    Given The '<field>' is filled incorrectly with '<parameter>' and the rest fields are filled with correct registration data
    Then The '<msg>' message is shown
    Examples:
      | field     | parameter           | msg                              |
      | password    | 99                  | passwd is invalid.           |
      | lastname | 999                 | lastname is invalid.|
      | firstname     | 99    | firstname is invalid.     |
      | phone_mobile    | mob    | phone_mobile is invalid.     |