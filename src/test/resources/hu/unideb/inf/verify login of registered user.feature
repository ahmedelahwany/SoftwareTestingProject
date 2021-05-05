# new feature
# Tags: optional

Feature: verify login of registered user with various possibilities


  Background:
    Given The AutomationPractice site is open
    And The Sign In Button is clicked
    And The email field is filled with valid user email



  Scenario Outline:
    Given The '<field>' is filled with '<parameter>'
    When The Login button is clicked
    Then The '<msg>' message is shown
    Examples:
      | field    | parameter         | msg                              |
      | passwd |                   | Password is required.            |
      | passwd | softwar           | Authentication failed.           |
      | passwd | sof               | Invalid password.                |

  Scenario:
    Given  The 'passwd' is filled with 'software'
    When The Login button is clicked
    Then verify Created user 'software testing' on the home page
    And Sign out