@Smoke
Feature: Validate Smart Bear Functionality
  Background:
    Given user is on "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx"
  Scenario: Validate invalid login attempt
    When user enters username as "abcd"
    And user enters password as "abcd1234"
    And user clicks on Login button
    Then user should see "Invalid Login or Password." message

  Scenario: Validate valid login attempt
    When user enters username as "Tester"
    And user enters password as "test"
    And user clicks on Login button
    Then user should be routed to "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/"





  
  
