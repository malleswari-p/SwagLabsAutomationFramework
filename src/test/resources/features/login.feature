@login
Feature: Login Functionality for Swag labs E-commerce Website

  As a user of the Swag labs website
  I want to be able to log in with valid credentials
  So that I can access orders and account

  Background:
    Given I am on the swag labs login page

  @acceptedLogins
  Scenario Outline: Login functionality with accepted usernames and passwords
    Given user entered the "<username>" and "<password>"
    When user click the login button
    Then user should navigate to Swag Labs products page

    Examples:
      |username               | password    |
      |standard_user          |secret_sauce |
      |locked_out_user        |secret_sauce |
      |problem_user           |secret_sauce |
      |performance_glitch_user|secret_sauce |

  @validInvalid
  Scenario Outline: Verify the login functionality with valid and invalid usernames, passwords
    Given user entered the "<username>" and "<password>"
    When user click the login button
    Then user should not navigate to Swag Labs products page

    Examples:
      |username               | password    |
      |standard_user          |secret_sauce1|
      |standard_user          |             |
      |standard_user1         |secret_sauce |
      |locked_out_user        |secret_sauce1|
      |locked_out_user        |             |
      |problem_user           |secret_sauce1|
      |problem_user           |             |
      |performance_glitch_user|secret_sauce1|
      |performance_glitch_user|             |


