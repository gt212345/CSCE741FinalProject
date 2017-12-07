#Author: heiru@email.sc.edu
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
@tag
Feature: Get all department information
  
  As a user of the system, I should be able to look into the information of all department

  @tag1
  Scenario Outline: Successful get all department information
    Given User is on homepage
    When User click the get all department button <button>
    Then webpage display correct department information <value>

    Examples: 
      | button           | value                                              |
      | getAllDeptButton | ["EMCH","ELCT","MATH","CSCE","ECHE","ECIV","BMEN"] |
