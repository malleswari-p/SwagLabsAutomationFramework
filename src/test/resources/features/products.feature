@products
Feature: Validating Products page functionality

  User want to verify the functionalities in Products page

  Background:
    Given I am on the swag labs login page

  @productTitle
  Scenario Outline: verify products title label is displayed
    Given user login to swag labs with valid credentials "<username>" and "<password>"
    Then user should see the product title label

    Examples:
      | username                | password      |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

  @productSort
  Scenario Outline: Check product sort option is displayed
    Given user login to swag labs with valid credentials "<username>" and "<password>"
    Then user should see the product sort option

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

  @productsDisplay
  Scenario Outline: Check whether inventory items are displayed correctly
    Given user login to swag labs with valid credentials "<username>" and "<password>"
    Then User should see the products correctly

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

  @sortZA
  Scenario Outline: Check whether product sort option ZA is working correctly
    Given user login to swag labs with valid credentials "<username>" and "<password>"
    When user click the sort ZA
    Then user should see the ZA sorted products

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

  @sortAZ
  Scenario Outline: Check whether product sort option AZ is working correctly
    Given user login to swag labs with valid credentials "<username>" and "<password>"
    When user click the sort AZ
    Then user should see the AZ sorted products

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

  @sortLowToHigh
  Scenario Outline: Check whether product sort option low to high is working correctly
    Given user login to swag labs with valid credentials "<username>" and "<password>"
    When user click the sort low to high
    Then user should see the low to high sorted products

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

  @sortHighToLow
  Scenario Outline: Check whether product sort option high to low is working correctly
    Given user login to swag labs with valid credentials "<username>" and "<password>"
    When user click the sort high to low
    Then user should see the high to low sorted products

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

  @productImages
  Scenario Outline: Check whether product images are displayed correctly
    Given user login to swag labs with valid credentials "<username>" and "<password>"
    Then user should validate the products images for users

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |


