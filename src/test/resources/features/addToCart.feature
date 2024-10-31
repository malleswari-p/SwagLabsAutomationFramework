@addToCart
Feature: Add To Cart functionality

  user want to verify all cart functions

  Background:
    Given I am on the swag labs login page

    @cartBadge
  Scenario Outline: Verify that user can see the cart badge get updated when add items to cart
    Given user login to swag labs with valid credentials "<username>" and "<password>"
    When user click the add to cart button <itemNumber>
    Then user should see the updated cart badge

    Examples:
      | username                | password     | itemNumber |
      | standard_user           | secret_sauce | 0          |
      | problem_user            | secret_sauce | 0          |
      | performance_glitch_user | secret_sauce | 0          |
      | standard_user           | secret_sauce | 1          |
      | problem_user            | secret_sauce | 1          |
      | performance_glitch_user | secret_sauce | 1          |
      | standard_user           | secret_sauce | 2          |
      | problem_user            | secret_sauce | 2          |
      | performance_glitch_user | secret_sauce | 2          |
      | standard_user           | secret_sauce | 3          |
      | problem_user            | secret_sauce | 3          |
      | performance_glitch_user | secret_sauce | 3          |
      | standard_user           | secret_sauce | 4          |
      | problem_user            | secret_sauce | 4          |
      | performance_glitch_user | secret_sauce | 4          |
      | standard_user           | secret_sauce | 5          |
      | problem_user            | secret_sauce | 5          |
      | performance_glitch_user | secret_sauce | 5          |

@removeButton
  Scenario Outline: Check user can see the remove button when add items to cart
    Given user login to swag labs with valid credentials "<username>" and "<password>"
    When user click the add to cart buttons
    Then user should see the remove button

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

@productView
  Scenario Outline: Check whether user can see the full product view
    Given user login to swag labs with valid credentials "<username>" and "<password>"
    When user click the product title <itemNumber>
    Then user should see the full product view

    Examples:
      | username                | password     | itemNumber |
      | standard_user           | secret_sauce | 0          |
      | problem_user            | secret_sauce | 0          |
      | performance_glitch_user | secret_sauce | 0          |
      | standard_user           | secret_sauce | 1          |
      | problem_user            | secret_sauce | 1          |
      | performance_glitch_user | secret_sauce | 1          |
      | standard_user           | secret_sauce | 2          |
      | problem_user            | secret_sauce | 2          |
      | performance_glitch_user | secret_sauce | 2          |
      | standard_user           | secret_sauce | 3          |
      | problem_user            | secret_sauce | 3          |
      | performance_glitch_user | secret_sauce | 3          |
      | standard_user           | secret_sauce | 4          |
      | problem_user            | secret_sauce | 4          |
      | performance_glitch_user | secret_sauce | 4          |
      | standard_user           | secret_sauce | 5          |
      | problem_user            | secret_sauce | 5          |
      | performance_glitch_user | secret_sauce | 5          |

  @itemsInCart
  Scenario Outline: Check user can see the products are added to cart
    Given user login to swag labs with valid credentials "<username>" and "<password>"
    When user click the add to cart buttons
    And user click the cart icon
    Then user should see the cart items added to cart

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

@withOutRemoveItems
  Scenario Outline: Check user can remove products from shopping cart
    Given user login to swag labs with valid credentials "<username>" and "<password>"
    And user click the add to cart buttons
    And user click the cart icon
    When user click the remove buttons
    Then user should see the cart without removed item

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

@backToProducts
  Scenario Outline: Check user can go to products from full product view page
    Given user login to swag labs with valid credentials "<username>" and "<password>"
    And user click the product title <itemNumber>
    When user click the back to products button
    Then user should see the product page

    Examples:
      | username                | password     | itemNumber |
      | standard_user           | secret_sauce | 0          |
      | problem_user            | secret_sauce | 0          |
      | performance_glitch_user | secret_sauce | 0          |

  @continueShopping
  Scenario Outline: Check user can go to products page from shopping cart
    Given user login to swag labs with valid credentials "<username>" and "<password>"
    And user click the add to cart buttons
    And user click the cart icon
    When user click the continue shopping button
    Then user should see the product page

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

    @checkoutInfo
  Scenario Outline: verify that user can navigate to checkout page from shopping cart
    Given user login to swag labs with valid credentials "<username>" and "<password>"
    And user click the add to cart buttons
    And user click the cart icon
    When user click the checkout button
    Then user should see the checkout info page

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |