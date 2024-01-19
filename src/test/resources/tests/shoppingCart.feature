Feature: Shopping Cart features

  Background:
    Given I am a user on Mega Image home page
    Then I validate cookie header and click accept cookies button

  Scenario: I can delete a product from shopping card
    When I click 'Adauga' button with index: 1
    When I click 'Shopping Cart' button
    Then I validate shopping cart url is correct
    When I click 'Remove product' button
    Then I validate empty basket message is displayed


  Scenario Outline: I can delete all product from shopping card
    When I click 'Adauga' button with index: <index_product>
    When I click 'Shopping Cart' button
    Examples:
      | index_product |
      | 1             |
      | 3             |
