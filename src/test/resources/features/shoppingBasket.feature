Feature: Shopping basket

  Scenario Outline: Items in the cart checkout
    Given the book '<title>' is available in shop
    And user has added <quantity> book(s) to shopping cart
    When user checks out the shopping cart
    Then the book '<title>' is listed in the final checkout
    And the total price of the cart is $<totalprice>

    Examples:
      | title                                | quantity | totalprice |
      | Beyond Order: 12 More Rules for Life | 2        | 34.80      |


