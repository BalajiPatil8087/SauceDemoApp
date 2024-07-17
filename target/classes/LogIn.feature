Feature: LogIn feature
  LogIn feature allow user to login into corresponding Swag Labs

 @SmokeTest
  Scenario: User is trying access Swag Labs account using invalid credentials
    Given User is on Swag Labs loging page
    When User enter wrong credentials
      | userName      | password      |
      | wrongUsername | worngPassword |
    And click on login
    Then 'Username and password do not match any user in this service' message should display

  Scenario: User is trying access Swag Labs account using valid credentials
    Given User is on Swag Labs loging page
    When User enter valid credentials
      | userName      | password     |
      | standard_user | secret_sauce |
    And click on login
    Then user able to see home page of corresponding Swag Labs account
