Feature: SauceDemo Login and Checkout Flow

  Scenario: Successful Login
    Given the user is on the SauceDemo login page
    When the user enters valid credentials
    And clicks the login button
    Then the user should be redirected to the products page
