Feature: User should be able to see a header on every page containing necessary content.
  @Header01
  Scenario Outline: As a user I navigate to different pages and see a header with all the content.
    Given I am on homepage
    When I navigate to "<page>"
    Then I can see a header with all the content
    Examples: Add any pages you wish to check footer
    | page            |
    | sign in page    |
    | contact us page |
    
  @Header02
  Scenario Outline: As a user I hover on header menu bar items and click on any sub-menu links
    Given I am on homepage
    When I hover on "woman menu" in header menu bar
    And I click "<link>"
    Then I am redirected to "<page>"
    Examples:
    | link                | page                |
    | t-shirts link       | t-shirts page       |
    | casual dresses link | casual dresses page |
    