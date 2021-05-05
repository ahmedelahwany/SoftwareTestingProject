# new feature
# Tags: optional

Feature: Adding an item to cart

  Background:
    Given The AutomationPractice site is open
    And   The 'search_query_top' is filled with 'Printed Summer Dress'

  Scenario Outline:
    Given The search button is clicked
    And The Image of the Item is clicked
    When The Add To cart Button and the proceed to checkout Btn is clicked
    Then The <msg> successful message is shown
    Examples:
      | msg                                      |
      | 'Your shopping cart contains: 1 Product' |


