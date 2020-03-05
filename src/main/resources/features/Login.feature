Feature: Login Module
  Test Login module functionality
@login @cicd
  Scenario: Login into PetClinic with existing user
    Given Browser is open
    When I login into PetClinic
    Then I am able to see the main page