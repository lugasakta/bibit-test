Feature: MyDemoPage

  Scenario: Buy 2 product in my demo app Given User choose product
    And User change variant to Blue
    And User scroll the product detail page
    And User add product to cart
    And User go to Cart page
    When User checkout from Cart page
    Then User will be redirected to Login page