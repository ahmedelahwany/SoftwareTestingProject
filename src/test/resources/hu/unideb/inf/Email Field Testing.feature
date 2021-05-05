Feature: Email Field Testing in Sign in Page

  Background:
    Given The AutomationPractice site is open
    And The Sign In Button is clicked

  Scenario Outline:
    Given The '<field>' is filled with '<parameter>'
    When The Login button is clicked
    Then The '<msg>' message is shown
    Examples:
      | field | parameter         | msg                              |
      | email |                   | An email address required.           |
      | email | invalid.email.com | Invalid email address.           |
      | email | valid@email.com   | Password is required.     |
