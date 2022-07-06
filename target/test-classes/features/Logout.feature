@wip
Feature: User can log out and ends up in login page.
  user story:As a user, I should be able to log out
  Users are : SalesManager, PosManager.
  Background: For the scenarios in the feature file, user is expected to be on the home page
    Given user is on the Upgenix home page
  Scenario: user logout
    When user clicks to user menu button
    And user clicks logout button
    Then user go to login page
  Scenario: The user can not go to the home page again by clicking the step back button after successfully logged out.
    When user back to page but doesn't see homepage