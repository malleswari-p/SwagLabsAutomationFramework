@loginErrors
Feature: Verifying the login error messages
      User want to see the proper error messages
      when login to the Swag Labs application is failed

  Background:
    Given I am on the swag labs login page

  @wrongUsers
  Scenario Outline: Check the error messages when login with invalid and blank username and password combinations
    Given user login to swag labs using different credential combinations <username> and <password>
    When user click the login button
    Then user should prompt the correct error message "<errormessage>"

    Examples:
      | username          | password          | errormessage                      |
      |   " "             |        " "        | Epic sadface: Username is required|
      |    " "            | "invalidpassword" | Epic sadface: Username is required|
      | "invalidusername" |     " "           | Epic sadface: Password is required|
      | "invalidusername" | "invalidpassword" | Epic sadface: Username and password do not match any user in this service|
