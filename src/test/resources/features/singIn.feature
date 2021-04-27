@RegresionTest
Feature: Signing up

  Scenario: Unhappy sign in - unfilled CAPTCHA
    Given Goes to Sign in page
    When user enters email and the correct password twice
    |email          | password    |
    |demo@demo.com  | password123 |
    But dont fill CAPTCHA field
    Then user should see message
    |message                                                 |
    |Enter the characters as they are given in the challenge.|