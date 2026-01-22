Feature: Add product to cart

  Scenario: Add to cart validation
    Given User is on home page
    When User clicks on Add to cart button of "Sarqwerty" card
    Then toast message should be displayed " Product Added To Cart "
    And Cart count is increased by 1
    And assertAll validations
    
   Scenario: Added product should be displayed in cart
    Given User is on home page
    When User clicks on Add to cart button of "Sarqwerty" card
    And Wait for invisibility of element
    And Clicked on the tab "Cart"
    Then Added product "Sarqwerty" should be displayed in cart 
    And assertAll validations