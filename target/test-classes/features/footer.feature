Feature: User should be able to see a footer on every page containing necessary content.
  @Footer01
  Scenario Outline: As a user I navigate to different pages and see a footer with all the content.
    Given I am on homepage
    When I navigate to "<page>"
    Then I can see a footer with all the content
    Examples: Add any pages you wish to check footer
    | page            |
    | sign in page    |
    | contact us page |
    
  @Footer02
  Scenario Outline: As a user I am signed in and I click on different links in footer and I get redirected to appropriate pages.
    Given I am signed in
    When I click "<link>"
    Then I am redirected to "<page>"
    And I sign out
    Examples:
    | link                  | page                  |
    | contact us link       | contact us page       |
    | my persolan info link | my persolan info page |
    | sign out link         | authentication page   |
    
  @Footer03
  Scenario: As a user I am on homepage and I subscribe to the newsletter using newsletter field in a footer.
    Given I am on homepage
    When I type my email in the newsletter field
    And I click "newsletter submit button"
    Then I see alert message that I have been successfully subscribed or email allready registered
