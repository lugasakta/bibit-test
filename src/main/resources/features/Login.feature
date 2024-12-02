Feature: Login MyDemoPage

  Scenario: User login to MyDemoPage Apps
    Given User go to login page
    And User input credentials
    When User click login
    Then User will be redirect to homepage