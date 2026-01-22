Feature: Place Order

  Scenario: place order validation
    Given User is on home page
    When User clicks on Add to cart button of "Sarqwerty" card
    And Wait for invisibility of element
    And Clicked on the tab "Cart"
    And Placed the order selecting country as "India"
    Then toast message should be displayed " Order Placed Successfully " 
    And "THANKYOU FOR THE ORDER." should be displayed
    And "Sarqwerty" product name should be displayed on order summary page
    And assertAll validations
    
   Scenario:  Insuffient information to place order
    Given User is on home page
    When User clicks on Add to cart button of "Sarqwerty" card
    And Wait for invisibility of element
    And Clicked on the tab "Cart"
    And Placed the order selecting country as ""
    Then toast message should be displayed " Please Enter Full Shipping Information "
    And assertAll validations