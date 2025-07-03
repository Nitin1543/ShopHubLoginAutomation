Feature: Login functionality for ShopHub

  Scenario: Valid Login
    Given User is on the login page
    When User enters valid username and password
    And Clicks the login button
    Then User should be redirected to the dashboard

  Scenario: Invalid Login
    Given User is on the login page
    When User enters invalid username and password
    And Clicks the login button
    Then An error message should be displayed