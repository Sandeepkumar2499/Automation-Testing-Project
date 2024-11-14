Feature: Account Page Testing
  As a user of Movies Website
  when i click on the account page section and
  I should see all UI details are present in and Account Page
  I want to logout my account and
  After logout i have to redirect to the loginPage



  Scenario: Test all the UI elements present on the 'Account Page'
    Given I am on the login page in 'Account Page'
    When I have enter the valid Username and Password in the 'Account Page'
    And I have click on the loginbutton in the 'Account Page'
    When I have click on account section in 'Account Page'
    And I have to verify the account page navigation 'Account Page'
    When I have to verify the NavBar section 'Account Page'
    Then I have to verify the account section 'Account Page'
    When I click on the logout button 'Account Page'
    Then I have to redirect to the login page 'Account Page'


  Scenario: Test the Logout functionality
    Given I am on the login page in 'Account Page'
    Then I have to redirect to the login page 'Account Page'


