Feature:Login functionality for E-commerce Application

As a user I am able to Login

Background:
Given I am on the openCart Login Page

Scenario: Successful login with valid credentials
Given I have entered valid username and password
When I click on login button
Then I should be logged successfully

