Feature: Search Product Investasi in Explore
  As a logged-in user
  I want to search for investment products
  So that I can explore suitable options.

  Scenario: Search for a product in the Explore section
    Given I am logged in to the Bibit website
    When I navigate to the "Explore" section
    And I search for "Investasi"
    Then I see search results relevant to "Investasi"
