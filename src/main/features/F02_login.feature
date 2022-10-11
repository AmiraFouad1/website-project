@smoke
Feature: F02_Login | users could use login functionality to use their accounts
  Background: Go to login page
    Given user go to login page

  Scenario: user could login with valid email and password
    When    user login with "valid" "amirafouad123@gmail.com" and "P@ssw0rd"
    And     user press on login button
    Then    user login to the system successfully


  Scenario: user could login with invalid email and password
    When    user login with "invalid" "amira@example.com" and "P@ssw0rd"
    And     user press on login button
    Then    user could not login to the system