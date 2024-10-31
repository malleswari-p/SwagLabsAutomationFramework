@Footer
Feature: Footer functionality

  user want to verify the Footer functionality

  Background:
    Given I am on the swag labs login page

  @footerDisplay
  Scenario Outline: Check whether footer is displayed is products page
    Given user login to swag labs with valid credentials "<username>" and "<password>"
    Then user should see the footer

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

  @footerText
  Scenario Outline: Check whether footer text is displaying correctly
    Given user login to swag labs with valid credentials "<username>" and "<password>"
    Then user should see the correct footer text

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

#    Footer links are not working - twitter link
  @twitterLink
  Scenario Outline: Check whether twitter is working correctly
    Given user login to swag labs with valid credentials "<username>" and "<password>"
    When user clicked on the twitter icon
    Then user should navigate to swag labs twitter page

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

#    Footer links are not working - facebook link
  @facebookLink
  Scenario Outline: Check whether facebook is working correctly
    Given user login to swag labs with valid credentials "<username>" and "<password>"
    When user clicked the facebook icon
    Then user should navigate to swag labs facebook page

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

#    Footer links are not working - linkedIn link
  @linkedInLink
  Scenario Outline: Check whether linkedin is working correctly
    Given user login to swag labs with valid credentials "<username>" and "<password>"
    When user clicked the linkedin icon
    Then user should navigate to swag labs linkedin page

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |