
@BRT-329
Feature: upgenix app login feature
  User story: As a user, I should be able to log in so that I can land on homepage.
  Users are : SalesManager, PosManager.
  Background:user is on the login page
    Given user is on the login page of upgenix app
  @BRT-323
  Scenario Template:Positive Login scenario
    When User enters valid "<Username>" and valid "<Password>"
    And user clicks to login button
    Then user should see the title is "Odoo"

    Examples:

      | Username                | Password     |
      | posmanager70@info.com   | posmanager   |
      | salesmanager90@info.com | salesmanager |
  @BRT-324
    Scenario Outline: Negative Login scenario
      When User enters valid "<Username>" and valid "<Password>"
      And user clicks to login button
      Then user should see "error message"
      Examples:

        | Username                | Password     |
        | posmanager70@info.com   | 123manager   |
        | salesmanager90@info.com | 456esmanager |
        | posmanager@info.com     | posmanager   |
        | salesmanage@info.com    | salesmanager  |
  @BRT-325
      Scenario Outline: Negative login Scenario
        When User enters valid "<Username>" and valid "<Password>"
        And user clicks to login button
        Then user should see message "Please fill out this field."
        Examples:

          | Username                | Password     |
          | posmanager70@info.com   |              |
          | salesmanager90@info.com |              |
          |                         | posmanager   |
          |                         | salesmanager |
          |                         |              |

  @BRT-326
  Scenario: Reset Password button
    When User enters "reset password" button
    Then  user go to  Reset password page
  @BRT-327
  Scenario Outline: User should see the password in bullet signs by default
    When User enters valid "<Username>" and valid "<Password>"
    Then user should see the password in bullet signs by default
    Examples:

      | Username                | Password     |
      | posmanager70@info.com   | posmanager   |
      | salesmanager90@info.com | salesmanager |
  @BRT-328
    Scenario Outline: the ‘Enter’ key of the keyboard is working correctly on the login page.
      When User enters valid "<Username>" and valid "<Password>"
      Then user clicks to enter key
      Examples:

        | Username                | Password     |
        | posmanager70@info.com   | posmanager   |
        | salesmanager90@info.com | salesmanager |






