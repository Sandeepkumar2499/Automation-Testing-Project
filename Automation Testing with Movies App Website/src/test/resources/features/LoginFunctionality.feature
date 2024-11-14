Feature: Login Page Test
  As a user of Movies Website
  I should test the Website with Login Functionality with Valid Username and Password
  and test with Login Functinality with Empty Username and Password

  Scenario: Test the login functionality with empty USERNAME
    Given I am on the login page in the Login Page 'Login Page'
    When I enter the Valid Password in the Login Page 'Login Page'
    When I click on the Login Button in the Login Page 'Login Page'
    Then I have to verify the error text 'Empty UserName Field' in the Login Page 'Login Page'

  Scenario: Test the login functionality with an empty PASSWORD
    Given I am on the login page in the Login Page 'Login Page'
    When I enter the Valid Username in the Login Page 'Login Page'
    When I click on the Login Button in the Login Page 'Login Page'
    Then I have to verify the error text 'Empty Password Field' in the Login Page 'Login Page'

  Scenario: Test the login functionality with Invalid Credentials
    Given I am on the login page in the Login Page 'Login Page'
    When I enter the Valid Username in the Login Page 'Login Page'
    When I enter the Wrong Password in the Login Page 'Login Page'
    When I click on the Login Button in the Login Page 'Login Page'
    Then I have to verify the error text 'Invalid Credintials Field' in the Login Page 'Login Page'

  Scenario: Test the login functionality with Valid Credentials
    Given I am on the login page in the Login Page 'Login Page'
    When I enter the Valid Username in the Login Page 'Login Page'
    When I enter the Wrong Password in the Login Page 'Login Page'
    When I click on the Login Button in the Login Page 'Login Page'
