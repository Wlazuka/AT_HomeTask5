@settings
Feature: Change the currency

  Scenario Outline: Change the currency to '<currency>'
    Given User is on Amazon main page
    When User goes to settings page
    And User change currency to: '<currency>'
    Then User sees message: '<message>'

    Examples:
      | currency            | message  |
      | EUR-euro            | EUR-note |
      | GBP-pound           | GBP-note |
      | NOK-Norwegian.Krone | NOK-note |