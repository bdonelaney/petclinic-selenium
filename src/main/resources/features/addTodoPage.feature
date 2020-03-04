Feature:Add a Todo to EY Module
  Add a Todo to EY functionality
  @addTodo @cicd
  Scenario: Add a Todo to EY page
    Given Browser is open
    When I login into EY mail
    Then I am able to see the main page
    Then Click on Todos Link
    Then Click on Add a Todo Link
    Then click on add link
    Then exit the page