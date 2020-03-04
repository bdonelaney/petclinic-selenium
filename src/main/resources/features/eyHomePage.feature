Feature: EY Home Page Module
  Test EY Home Page functionality
  @eyhome @cicd
  Scenario: Logout from EY page
    Given Browser is open
    When I login into EY mail
    Then I am able to see the main page
    Then Click on EY Link
    Then exit the page