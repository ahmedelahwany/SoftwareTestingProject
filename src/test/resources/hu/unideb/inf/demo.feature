Feature: Contact Us testing ( email Field)

  Background:
    Given The AutomationPractice site is open
    And The Contact Us link is clicked

    Scenario Outline:
      Given The '<field>' is filled with '<parameter>'
      When The Send button is clicked
      Then The '<msg>' message is shown
      Examples:
        | field | parameter         | msg                              |
        | email |                   | Invalid email address.           |
        | email | invalid.email.com | Invalid email address.           |
        | email | valid@email.com   | The message cannot be blank.     |
