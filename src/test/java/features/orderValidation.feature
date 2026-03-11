@order
Feature: Order

	Background:
    Given User is on home page

  Scenario: order validation
    When User clicks Add to cart button of "Sarqwerty" card and waits until the toast disappears
    And Clicked on the tab "Cart"
    And Placed the order selecting country as "India"
    And fetch the generated orderID
    And Clicked on the tab "Orders"
    Then orderID should be same as displayed in the order summary page
    And assertAll validations