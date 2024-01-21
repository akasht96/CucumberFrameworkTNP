@searchFuncationality
Feature: Search Functionality

  @searchtag1
  Scenario: User searches for valid product
	Given User on the application
	When User enters valid product "HP" into search box field
	And User clicks on search button
	Then user should get valid product displayed in search results
	
	@searchtag2
  Scenario: User searches for Invalid product
	Given User on the application
	When User enters Invalid product "Honda" into search box field
	And User clicks on search button
	Then user should get proper warning message about no product matching
	
	@searchtag3
  Scenario: User searches without product
	Given User on the application
	And User clicks on search button
	Then user should get proper warning message about no product matching
	
	