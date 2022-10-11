@smoke
Feature: F08_Wishlist|users could add an item to their wishlist and then check it out later

  Scenario: user adds an item to the wishlist
    When user clicks on wishlist button on product
    Then success message is visible


  Scenario: user adds an item to the wishlist and checks wishlist
    When user clicks on wishlist button on product
    Then  success message is visible
    And user get the number wishlist items
    Then number of wishlist increased