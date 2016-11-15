Feature: As a user I am able to search for products and arrange and sort the results in different ways, and see the count of results.
  @Search01
  Scenario Outline: I type different products in search field and can see the number of results or message if there is no results
    Given I am on homepage
    When I type a "<name>" of a product in a search field
    And I click "search button"
    Then I am redirected to "search results page"
    And I can see number of results or "<name>" message if no results
    Examples:
    | name   |
    | dress  |
    | shoes  |
    | jeans  |
    | jacket |

  @Search02
  Scenario Outline: I search for a product and can sort results and switch view type
    Given I am on homepage
    And I type "dress" in a search field
    And I click "search button"
    Then I am redirected to "search results page"
    And I switch to "list" view
    And I sort results by "<sort type>"
    Examples:
    | sort type                |
    | Product Name: A to Z     |
    | Price: Lowest first      |
    | In stock                 |
    | Reference: Highest first |
