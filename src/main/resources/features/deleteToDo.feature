Feature: Delete Todo from EY page
  Delete Todo from EY page functionality
  @deleteodo @cicd
  Scenario: Delete Todo from EY page
    Given Browser is open
    When I login into EY mail
    Then I am able to see the main page
    Then Click on Click Here Link
    Then Click on Delete Button
    Then exit the page