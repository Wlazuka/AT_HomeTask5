Feature: Change the currency

  Background: User is on Amazon main page

  Scenario Outline: Change the currency to '<currency>'
    When User goes to currency change page
    And User change currency to: '<currency>'
    Then User sees message: '<message>'


    Examples:
      | currency          | message  |
      | EUR - Euro        | EUR note |
      | GBP - Pounds      | GBP note |
      | USD - U.S. Dollar | USD note |