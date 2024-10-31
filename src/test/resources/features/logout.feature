@logout
Feature: Logout from the Swag labs Application

  verifying that user want to logout
  from the Swag Labs application

  Background:
    Given I am on the swag labs login page

  @validLogout
  Scenario Outline: Logout from the Swag labs application
    Given user login to swag labs with valid credentials "<username>" and "<password>"
    And user should navigate to left sidebar
    When user click the logout button
    Then user should logout from Swag Labs application

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

  @closingLogout
  Scenario Outline: Verify Products home page closing the application without logging out and reopening
    Given user login to swag labs with valid credentials "<username>" and "<password>"
    And user closes the application without log out
    When user launch the browser and open the application url
    Then user should navigate to login page

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
