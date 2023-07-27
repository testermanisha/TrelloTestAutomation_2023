Feature: Trello workspace AutoTests
  I want to use this template for my feature file

  Scenario: Check user can sign up for free
    Given user is on sign up page
    When user enters the email address on the sign up page
    And clicks on the signup button
    Then user is navigated to the sign up to continue page
    And clicks on the sign up button
    Then user is navigated to the verify screen
    Then user is navigated to the Trello Home page