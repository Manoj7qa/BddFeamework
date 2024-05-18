
Feature: Title of your feature
 Scenario: Filtering price without applying filter in application
    Given User Launch Chrome Browser
    When User open URL "https://www.saucedemo.com/"
    Then Login Page title should be "Swag Labs"
    And Enter UN "standard_user" and PWD "secret_sauce"
    And Click on Login Button 
    Then Home Page title should be "Swag Labs"
    Then Get all product price without filter
    Then Logout from the portal
    Then Login Page title should be "Swag Labs"
    And Close browse
    

