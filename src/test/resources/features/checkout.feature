@checkout
Feature: Checkout functionality

  user want to check out the products added in shopping cart

  Background:
    Given I am on the swag labs login page

  @checkoutOverview
  Scenario Outline: verify that user is able to fill the details in checkout page
    Given user login to swag labs with valid credentials "<username>" and "<password>"
    And user click the add to cart buttons
    And user click the cart icon
    And user click the checkout button
    And user should see the checkout info page
    And user should fill the "<firstname>","<lastname>","<postalcode>" information in checkout info page
    When user click on the continue button
    Then user should navigate to checkout overview page

    Examples:
      | username                | password     | firstname | lastname | postalcode |
      | standard_user           | secret_sauce | Test      | Order    | 67637      |
      | problem_user            | secret_sauce | Test      | Order    | 67634      |
      | performance_glitch_user | secret_sauce | Test      | Order    | 67632      |

  @backToCart
  Scenario Outline: verify that user is able to cancel the order in checkout info page
    Given user login to swag labs with valid credentials "<username>" and "<password>"
    And user click the add to cart buttons
    And user click the cart icon
    And user click the checkout button
    And user should see the checkout info page
    And user should fill the "<firstname>","<lastname>","<postalcode>" information in checkout info page
    When user click on the cancel button
    Then user should navigate to shopping cart page

    Examples:
      | username                | password     | firstname | lastname | postalcode |
      | standard_user           | secret_sauce | Test      | Order    | 67637      |
      | problem_user            | secret_sauce | Test      | Order    | 67634      |
      | performance_glitch_user | secret_sauce | Test      | Order    | 67632      |


  @errorsInInfoPage
  Scenario Outline: verify that user is able to get error warnings for mandatory fields in checkout info page
    Given user login to swag labs with valid credentials "<username>" and "<password>"
    And user click the add to cart buttons
    And user click the cart icon
    And user click the checkout button
    And user should see the checkout info page
    And user should leave any fields <firstname>,<lastname>,<postalcode> blank in checkout info page
    When user click on the continue button
    Then user should prompt the correct error message "<errormessage>" in checkout info page

    Examples:
      | username                | password     | firstname | lastname | postalcode | errormessage |
      | standard_user           | secret_sauce |           |          |            | Error: First Name is required |
      | standard_user           | secret_sauce | Test      |          |            | Error: Last Name is required  |
      | standard_user           | secret_sauce | Test      | Order    |            | Error: Postal Code is required|
      | standard_user           | secret_sauce | Test      |          | 67637      | Error: Last Name is required  |
      | standard_user           | secret_sauce |           | Order    | 67637      | Error: First Name is required |
      | problem_user            | secret_sauce | Test      |          | 67634      | Error: Last Name is required  |
      | performance_glitch_user | secret_sauce | Test      | Order    |            | Error: Postal Code is required|

 @backToProducts
  Scenario Outline: verify that user is able to cancel the order in checkout overview page
    Given user login to swag labs with valid credentials "<username>" and "<password>"
    And user click the add to cart buttons
    And user click the cart icon
    And user click the checkout button
    And user should see the checkout info page
    And user should fill the "<firstname>","<lastname>","<postalcode>" information in checkout info page
    And user click on the continue button
    And user should navigate to checkout overview page
    When user click on the cancel button
    Then user should navigate to Swag Labs products page

    Examples:
      | username                | password     | firstname | lastname | postalcode |
      | standard_user           | secret_sauce | Test      | Order    | 67637      |
      | problem_user            | secret_sauce | Test      | Order    | 67634      |
      | performance_glitch_user | secret_sauce | Test      | Order    | 67632      |

  @checkoutComplete
  Scenario Outline: verify that user is able to click on Finish the order in checkout overview page
    Given user login to swag labs with valid credentials "<username>" and "<password>"
    And user click the add to cart buttons
    And user click the cart icon
    And user click the checkout button
    And user should see the checkout info page
    And user should fill the "<firstname>","<lastname>","<postalcode>" information in checkout info page
    And user click on the continue button
    And user should navigate to checkout overview page
    And user should verify all the details in checkout overview page
    When user click on the finish button
    Then user should navigate to checkout complete page

    Examples:
      | username                | password     | firstname | lastname | postalcode |
      | standard_user           | secret_sauce | Test      | Order    | 67637      |
      | problem_user            | secret_sauce | Test      | Order    | 67634      |
      | performance_glitch_user | secret_sauce | Test      | Order    | 67632      |

  @successAndShipping
  Scenario Outline: user is able to verify the success message and shipping info in checkout complete page
    Given user login to swag labs with valid credentials "<username>" and "<password>"
    And user click the add to cart buttons
    And user click the cart icon
    And user click the checkout button
    And user should see the checkout info page
    And user should fill the "<firstname>","<lastname>","<postalcode>" information in checkout info page
    And user click on the continue button
    And user should navigate to checkout overview page
    And user should verify all the details in checkout overview page
    And user click on the finish button
    When user should navigate to checkout complete page
    Then user should verify the success message "<success>" and shipping info in checkout complete page

    Examples:
      | username                | password     | firstname | lastname | postalcode | success                   |
      | standard_user           | secret_sauce | Test      | Order    | 67637      | THANK YOU FOR YOUR ORDER  |
      | problem_user            | secret_sauce | Test      | Order    | 67634      | THANK YOU FOR YOUR ORDER  |
      | performance_glitch_user | secret_sauce | Test      | Order    | 67632      | THANK YOU FOR YOUR ORDER  |

  @invalidScenario
  Scenario Outline: verify that user can checkout the empty cart
    Given user login to swag labs with valid credentials "<username>" and "<password>"
    And user click the cart icon
    And user click the checkout button
    And user should see the checkout info page
    And user should fill the "<firstname>","<lastname>","<postalcode>" information in checkout info page
    And user click on the continue button
    And user should navigate to checkout overview page
    And user should verify all the details in checkout overview page
    And user click on the finish button
    When user should navigate to checkout complete page
    Then user should verify the success message "<success>" and shipping info in checkout complete page

    Examples:
      | username                | password     | firstname | lastname | postalcode | success                   |
      | standard_user           | secret_sauce | Test      | Order    | 67637      | THANK YOU FOR YOUR ORDER  |
      | problem_user            | secret_sauce | Test      | Order    | 67634      | THANK YOU FOR YOUR ORDER  |
      | performance_glitch_user | secret_sauce | Test      | Order    | 67632      | THANK YOU FOR YOUR ORDER  |
