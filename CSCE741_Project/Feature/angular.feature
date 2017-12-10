#Author: heiru@email.sc.edu
#Date: 2017/12/09
@angular
Feature: Angular behavior
  
  To test the angular UI behavior

  @angular
  Scenario Outline: Test login
    Given I want log in to the system
    When I am on the home page
    Then I try to log in with <username> and <password>
    And The system return correct page with url <url>

    Examples: 
      | username | password | url                               |
      | "admin"  | "admin"  | "http://localhost:4200/dashboard" |
      | "abd"    | "abd"    | "http://localhost:4200/dashboard" |
