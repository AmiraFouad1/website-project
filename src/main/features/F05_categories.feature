@smoke
Feature: F05_HoverCategories|user could hover categories and select sub category

  Scenario: user could hover on one of main categories
    When    user hover category and select subcategory
    And     user click on subcategory
    Then    user go to relative product page
