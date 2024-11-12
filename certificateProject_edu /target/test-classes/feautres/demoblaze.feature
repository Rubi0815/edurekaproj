

Feature: Portal and login page validation

 # @Scenario1
  Scenario: To verify the URL for Demoblaze on google browser
  
    Given The user is on the google chrome browser and application URL is opened
    And User enters URL and opens the application Home page through URL
    Then The application Home page is displayed

  #@Scenario2
  Scenario: To verify the User can access sign up Window
    
    Given User is on the application Home page
    When User clicks on the signup link
    Then The signup window is displayed
    And All elements in the signup window are visible

  #@Scenario3
  Scenario: To Sign up on portal
    
    Given User is on the application Home page
    When User clicks on the signup link
    Then Enters a valid username and password 
    And  clicks on the signup button
    And User should be successfully registered
    And A greeting message should be displayed
    
    
  #@Scenario outlinle
  Scenario Outline: Check login is successful with valid credentials
   
    Given User is on the application Home page
    When User clicks on the signup link
    Then Enters a valid username <username> and password <password> 
    And  clicks on the signup button
    And User should be successfully registered
    And A greeting message should be displayed
     
    
    Examples: 
    | username                     | password   |
    |   user011                     | password@11|
    |   user022                     | password@22|
    |   user033                     | password@33|
    
    

  #@Scenario4
  Scenario: User is not able to register if  given username already exists
    
    Given User is on the application Home page
    When User clicks on the signup link
    And Enters existed username and valid password
    And Click on signup button
    But User credentials are wrong
    Then User should not be able to register into the application
    And An error message should be displayed for the existing username
