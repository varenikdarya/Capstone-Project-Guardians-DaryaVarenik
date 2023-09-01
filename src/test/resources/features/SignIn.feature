@smoke
Feature: Sign in Feature

  Background: 
    Given User is on retail website
    When User click on Sign in option

  @signIn
  Scenario: Verify user can sign in into Retail Application
    And User enter email 'guardiansclass@gmail.com' and password 'Class2023!'
    And User click on login button
    Then User should be logged in into Account

  @createAccount
  Scenario: Verify user can create an account into Retail Website
    And User click on Create New Account button
    And User fill the signUp information with below data
      | name | email      | password      | confirmPassword |
      | Hope | emailValue | Guardians@123 | Guardians@123   |
    And User click on SignUp button
    Then User should be logged into account page
