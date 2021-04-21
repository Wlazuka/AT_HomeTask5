Feature: Change the currency

  Scenario: Breaker joins a game
    Given User is on Amazon main page
    When User goes to change currency page
    And User change currency to:
    Then User sees message:

    Examples:
      | Currency            | message |
      | Friday              | TGIF   |
      | Sunday              | Nope   |
      | anything else!      | Nope   |