@api
Feature: JSONPlaceholder API

  Scenario: Retrieve user 1
    When I request user 1 from JSONPlaceholder
    Then the response status should be 200
    And the response username should be "Bret"
