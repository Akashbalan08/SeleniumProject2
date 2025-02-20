Feature: SauceDemo Login and Checkout Flow

  Scenario: Successful Login
    Given the user is on the SauceDemo login page
    When the user enters valid credentials
    And clicks the login button
    Then the user should be redirected to the products page
    
    
  Scenario: Invalid Login
    Given the user is on the SauceDemo login page
    When the user enters invalid credentials
    And clicks the login button
    Then the user should be displayed with a warning message
    
  Scenario: User checkout single item
    Given the user is on the SauceDemo login page
    When the user enters valid credentials
    And clicks the login button
    And the user must be directed to the products page
    And the user adds item to cart
    And the user clicks on cart button
    And the user clicks on checkout button
    And the user fills additional info and continue to checkout
    And the user clicks on finish button
    Then the user must be displayed with the thank you message
    
  Scenario: User checkout multiple items
    Given the user is on the SauceDemo login page
    When the user enters valid credentials
    And clicks the login button
    And the user must be directed to the products page
    And the user adds multiple items to cart
    And the user clicks on cart button
    And the user clicks on checkout button
    And the user fills additional info and continue to checkout
    And the user clicks on finish button
    Then the user must be displayed with the thank you message
    

  Scenario: Successful Login/Logout flow
    Given the user is on the SauceDemo login page
    When the user enters valid credentials
    And clicks the login button
    And the user must be directed to the products page
    And the user clicks on the hamburger menu and logout
    Then the user is redirected to login page
    
    
 
