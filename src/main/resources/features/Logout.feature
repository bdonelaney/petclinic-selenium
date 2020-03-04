Feature: Logout Module
  Test Logout module functionality
@logout @cicd
  Scenario: Logout from EY page
    Given Browser is open
    When I login into EY mail
    Then I am able to see the main page
    Then Click on logout button
    Then exit the page