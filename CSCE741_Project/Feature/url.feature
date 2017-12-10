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
@url
Feature: Get url content
  
  As a user of the system, I should be able to get the content of all provided url

  @url
  Scenario Outline: Successful get all department information
    Given User is on homepage
    When User click the get all department button
    Then webpage display correct department information <value>

    Examples: 
      | value                                              |
      | ["EMCH","ELCT","MATH","CSCE","ECHE","ECIV","BMEN"] |

  @url
  Scenario Outline: Successful get all instructor in CSCE department
    Given User is on homepage
    When User click the get all instructor for a specfic department button
    Then The system ask for department input <input>
    And webpage display correct instructor information <value>

    Examples: 
      | input  | value                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
      | "CSCE" | ["Jeremiah Jeffrey Shepherd","James Paul O'Reilly","Marco Valtorta","Mingxiang Zhu","Christine M.G. Brown","Jianjun Hu","Chin-Tser Huang","Ivelisse Ortiz-Hernandez","Jeremy Shane Lewis","Song Wang","Dazhou Guo","Patrick B. O'Keefe","Duncan A. Buell","Homayoun Valafar","Casey Anne Cole","Ioannis M Rekleitis","Alberto Quattrini Li","Stephen A. Fenner","Srihari Nelakuditi","Jason Daniel Bakos","Manton M. Matthews","Veronica L. Wilkinson","Csilla Farkas","John R. Rose","Gregory James Gay","Jason Matthew Okane","TBA"] |
      | "ECHE" | ["William Earl Mustain","Ahmed Shehab Khan","Michael A. Matthews","Jeremy Shane Lewis","Xiao-Dong Zhou","Andreas Heyden","Vincent Van Brunt","James A. Ritter","Bihter Padak","Branko N. Popov","Ralph E. White","Mark Jacob Uline","James Otto Blanchette","TBA"]                                                                                                                                                                                                                                                                     |
