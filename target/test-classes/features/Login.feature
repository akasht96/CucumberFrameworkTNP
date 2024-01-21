@loginfeature
Feature: Login Functionality

  @SC_validLogin @Sclogincheck
  Scenario Outline: login with valid credentials
  Given User Navigates to login Page
  When User has entered a valid emailaddress <Username> into email field
  And User has entered a valid password <Password> into password field
  And User Clicked on login button
  Then User Should get successfully loged in 
  Examples:
  |Username								|Password			|
  |asthakare@gmail.com		|Akash@6543		|
  |asthakare@gmail12.com	|Akash@6543dd	|
  |asthakare@gmail.com		|Akash@6543		|
  
  @SC_InvalidLogin @Sclogincheck
  Scenario: login with Invalid credentials
  Given User Navigates to login Page
  When User has entered a Invalid emailaddress into email field
  And User has entered a Invalid password "Akash@6543hjbjbj" into password field
  And User Clicked on login button
  Then User Should get a proper warning message credentials mismatched
  
  @tag3
  Scenario: login with valid Email and Invalid Password credentials
  Given User Navigates to login Page
  When User has entered a valid emailaddress "asthakare@gmail.com" into email field
  And User has entered a Invalid password "Akash@6543hjbjbj" into password field
  And User Clicked on login button
  Then User Should get a proper warning message credentials mismatched
  
  @tag4
  Scenario: login with Invalid Email and valid Password credentials
  Given User Navigates to login Page
  When User has entered a Invalid emailaddress into email field
  And User has entered a valid password "Akash@6543" into password field
  And User Clicked on login button
  Then User Should get a proper warning message credentials mismatched
  
  @tag5
  Scenario: login without credentials
  Given User Navigates to login Page
  And User Clicked on login button
  Then User Should get a proper warning message credentials mismatched
  
