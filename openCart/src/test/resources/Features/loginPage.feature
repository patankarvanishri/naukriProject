Feature:Login functionality for E-commerce Application

As a user I am able to Login

Background:
Given I am on the openCart Login Page

Scenario: Successful login with valid credentials
Given I have entered valid username and password
When I click on login button
Then I should be logged successfully

#Scenario: Update profile summary
Given I click on update profile button
Then I am on the profile page
And I click on edit resume headline
Then I have entered text "Immediate Joiner | LWD: 4th Sep | ISTQB Certified | Automation testing | Selenium | Core Java |Cucumber| TestNG | restAssured"
And I save the headline


