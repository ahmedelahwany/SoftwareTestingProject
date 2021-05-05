# new feature
# Tags: optional

Feature: Decreasing item count in the cart
  Background:
    Given The AutomationPractice site is open
    And  The 'search_query_top' is filled with 'Printed Summer Dress'

  Scenario Outline:
    Given The search button ,add to cart button and proceed to checkout button are clicked
    And The plus button is clicked
    When The minus button is clicked
    Then The item count changes to <number>
    Examples:
      | number |
      | '2'    |
