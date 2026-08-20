@ui
Feature: SauceDemo login

  Scenario: Successful login
    Given I am on the SauceDemo login page
    When I log in with valid credentials
    Then I should see the Products page

  Scenario: Login fails with invalid credentials
    Given I am on the SauceDemo login page
    When I log in with invalid credentials
    Then I should see the expected login error
