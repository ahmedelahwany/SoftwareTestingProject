# new feature
# Tags: optional

Feature: Increasing item count in the cart
  Background:
    Given The AutomationPractice site is open

  Scenario Outline:
    Given The <field> is filled with <parameter>
    And The search button ,add to cart button and proceed to checkout button are clicked
    When The plus button is clicked
    Then The item count changes to <number>
    Examples:
      | field              | parameter              | number |
      | 'search_query_top' | 'Printed Summer Dress' | '3'    |

