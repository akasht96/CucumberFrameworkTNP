@RegisterFunctionality
Feature: Register Functionality

  @Regitag1
  Scenario: User create a account with mandatory fields
    Given User Navigates to Register account Page
    When User enters a "Akash04" first name
    And User enters a "Thakare" last name
    And User enters a email address
    And User enters a "1234567890" telephone number
    And User enters a "12345" password
    And User enters a "12345" confirm password
    And User selects privacy policy
    And User clicks on continue button
    Then user account should get created successfully
    
    @Regitag2
  Scenario: User create a account with all fields
    Given User Navigates to Register account Page
    When User enters a "Akash04" first name
    And User enters a "Thakare" last name
    And User enters a email address
    And User enters a "1234567890" telephone number
    And User enters a "12345" password
    And User enters a "12345" confirm password
    And User select yes for newslater
    And User selects privacy policy
    And User clicks on continue button
    Then user account should get created successfully
    
    @Regitag3
  Scenario: User create a duplicate account 
    Given User Navigates to Register account Page
    When User enters a "Akash04" first name
    And User enters a "Thakare" last name
    And User enters a duplicate "akasht01@gmail.com" email address
    And User enters a "1234567890" telephone number
    And User enters a "12345" password
    And User enters a "12345" confirm password
    And User select yes for newslater
    And User selects privacy policy
    And User clicks on continue button
    Then user should get a warning about duplicate email
    
    @Regitag4
  Scenario: User create a account without filling any fields
    Given User Navigates to Register account Page
    And User clicks on continue button
    Then user should get warning messages for every mandatory fields
    
