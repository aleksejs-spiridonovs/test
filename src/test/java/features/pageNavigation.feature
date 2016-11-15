Feature: User should be able to see and navigate to any previous pages on path from homebage from any page except homepage with page navigation bar 
  @Navigation01
  Scenario: I as a user navigate to casual dresses page and I can see the navigatin bar and I navigate to homepage 
    Given I am on homepage
    And I navigate to "casual dresses page"
    And I can see the home and dress link on naviation bar
    When I click "navigation bar home button"
    Then I am redirected to "home page"
