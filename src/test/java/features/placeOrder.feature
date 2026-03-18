
Feature: Place Order

	Background:
    Given User is on home page

  @order
  Scenario: place order validation
    When User clicks Add to cart button of "Sarqwerty" card and waits until the toast disappears
    And Clicked on the tab "Cart"
    And Placed the order selecting country as "India"
    Then toast message should be displayed " Order Placed Successfully " 
    And "THANKYOU FOR THE ORDER." should be displayed
    And "Sarqwerty" product name should be displayed on order summary page
    And assertAll validations
    
   @order 
   Scenario:  Insuffient information to place order
    When User clicks Add to cart button of "Sarqwerty" card and waits until the toast disappears
    And Clicked on the tab "Cart"
    And Placed the order selecting country as ""
    Then toast message should be displayed " Please Enter Full Shipping Information "
    And assertAll validations