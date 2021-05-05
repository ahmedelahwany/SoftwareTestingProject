Feature: YourLogo sign in page test

  Background:
    Given The AutomationPractice site is open

  Scenario Outline:
    Given The '<field>' is filled with '<parameter>'
    When The search button is clicked
    Then The '<msg>' search error message is shown
    Examples:
      | field            | parameter               | msg                                                                                        |
      | search_query_top |  invalid searchdasdsdd  | No results were found for your search "invalid searchdasdsdd"                              |
      | search_query_top |                         | Please enter a search keyword                                                              |

