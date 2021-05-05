Feature: Contact Us testing ( Message Field)

  Background:
    Given The AutomationPractice site is open
    And The Contact Us link is clicked

  Scenario Outline:
    Given The '<field>' is filled with '<parameter>'
    And The email field is filled with valid email
    When The Send button is clicked
    Then The '<msg>' message is shown
    Examples:
      | field   | parameter         | msg                                                       |
      | message |valid message data | Please select a subject from the list provided.           |
      | message |                   | The message cannot be blank.                              |

