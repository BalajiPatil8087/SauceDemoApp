Feature: HomePage feature
  This Feature help to user to add to cart the products

  @SmokeTest
  Scenario: Add multiple products to the cart
    Given User is on Swag Labs loging page
    When User enter valid credentials
      | userName      | password     |
      | standard_user | secret_sauce |
    And click on login
    Given User is already login on Swag Labs loging page
    Then User add "products" in cart
      | products                |
      | Sauce Labs Backpack     |
      | SaSauce Labs Backpackuce Labs Bike Light   |
      | Sauce Labs Bolt T-Shirt |
    And click on shopping cart container
    And click on checkout
    And user should enter checkout information
      | firstName | lastName | postalCode |
      | Ram       | Sham     |       1234 |
    And click on continue
    And User is able to see added products
    And click on finish
    Then User is able to see Thank you for your order Meassage
    And User logout from the screen
