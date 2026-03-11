@cart
Feature: Add product to cart

	Background:
    Given User is on home page

  Scenario: Add to cart validation
    When User clicks on Add to cart button of "Sarqwerty" card
    Then toast message should be displayed " Product Added To Cart "
    And Cart count is increased by 1
    And assertAll validations
    
   Scenario: Added product should be displayed in cart
    When User clicks Add to cart button for "Sarqwerty" card and waits until the toast disappears
    And Clicked on the tab "Cart"
    Then Added product "Sarqwerty" should be displayed in cart 
    And assertAll validations