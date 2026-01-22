Feature: Order

  Scenario: order validation
    Given User is on home page
    When User clicks on Add to cart button of "Sarqwerty" card
    And Wait for invisibility of element
    And Clicked on the tab "Cart"
    And Placed the order selecting country as "India"
    And fetch the generated orderID
    And Clicked on the tab "Orders"
    Then orderID should be same as displayed in the order summary page
    And assertAll validations