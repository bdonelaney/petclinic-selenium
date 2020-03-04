Feature: ToDo Module
  Test Todo module functionality
  @todo @cicd
  Scenario: Logout from EY page
    Given Browser is open
    When I login into EY mail
    Then I am able to see the main page
    Then Click on Click Here Link
    Then exit the page