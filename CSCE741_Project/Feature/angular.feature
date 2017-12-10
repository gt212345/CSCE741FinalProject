#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@angular
Feature: Angular behavior
  
  I want to tes the angular UI behavior

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
