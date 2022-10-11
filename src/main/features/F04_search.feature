@smoke
Feature:

  Scenario Outline:  user could search using product name
    When  user click on search field
    And user search with "<product name>"
    Then user could find  "<product name>" relative words


    Examples:
      | product name |
      | book         |
      | laptop       |
      | nike         |


  Scenario Outline:  user could search for product using sku
    When  user click on search field
    And user search with "<sku>"
    Then user could find  "<sku>" inside product detail page


    Examples:
      | sku          |
      | SCI_FAITH    |
      | APPLE_CAM    |
      |  SF_PRO_11   |