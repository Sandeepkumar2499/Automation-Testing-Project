
Feature: Header Page Test
  As a user of Movies Website
  I should see the Website logo and
  All the Navbar elements and I should navigate to all the corressponding
  pages successfully.


  Scenario: Test the Header Section UI
    Given I am on the login page in the Header Page 'Header Page'
    When  I have enter the valid Username and Password for Header Page 'Header Page'
    And I have click the login button Header Page 'Header Page'
    Then I have to check the logo and navBar's items are visibleHeader Page 'Header Page'


  Scenario: Test the Header Section Functionalities
    Given I am on the login page in the Header Page 'Header Page'
    When I have enter the valid Username and Password for Header Page 'Header Page'
    And I have click the login button Header Page 'Header Page'
    And I have to check home section in header page 'Header Page'
    And I have to check the popular section in header page 'Header Page'
    Then I have to check the account section in header page 'Header Page'