@settings
Feature: Change the language

  Scenario Outline: Change the language to: '<language>'
    Given User is on Amazon main page
    When User goes to settings page
    And User change language to: '<language>'
    Then User sees '<message>' in '<language>'
    And Translation "<text>" is also in '<language>'

    Examples:
      | language  | message | text                 |
      | English   | ENG-msg | ENG-translation-text |
      | Espanol   | ES-msg  | ES-translation-text  |
      | Deutsh    | DE-msg  | DE-translation-text  |
      | Portugues | PT-msg  | PT-translation-text  |


