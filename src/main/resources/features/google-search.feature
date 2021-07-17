Feature: Validate the google search page
@google
  Scenario Outline: Validate google site
    Given I am on google home page
    When I give the "<keyword>" as input
    And I click on the search keyword
    Then I should see atleast <count> outputs

    Examples: 
      | keyword    | count |
      | java       |     3 |
      | selenium   |     5 |
      | springboot |   400 |
