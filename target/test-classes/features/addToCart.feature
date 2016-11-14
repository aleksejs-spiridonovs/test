Feature: User should be able to add products to shopping cart or choose quantity, size and color before adding.
  @Test01
  Scenario: I as a user I navigate to casual dresses page and add one to my shopping cart, I can see one product added to the cart.
    Given I am on homepage
    And I navigate to "casual dresses page"
    When I click on add to cart button
    And I choose to "continue shopping" in pop up window
    Then I can see a product added to my cart
