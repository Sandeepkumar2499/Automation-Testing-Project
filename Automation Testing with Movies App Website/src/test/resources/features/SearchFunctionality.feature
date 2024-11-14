Feature:  Search page Test
  As a user of the movies website
  I should Test the SearchPage with success case and
  SearchPage with Failure Case and
  Redirect to the movie details page.


  Scenario: Test the Search Page with Success Case
    Given I am on Login the page in the Search Page 'Search Page'
    When I enter the valid username and password for Search Page 'Search Page'
    And I click on the login button for Search Page 'Search Page'
    When I click on Search Bar in search page 'Search Page'
    And I enter the valid movie name in the Seacrh Page 'Search Page'
    When I click on the search button in search page 'Search Page'
    Then I have verify the Number of Movies in the Search Page 'Search Page'




  Scenario: Test the Search Page with Failure Case
    Given I am on Login the page in the Search Page 'Search Page'
    When I enter the valid username and password for Search Page 'Search Page'
    And I click on the login button for Search Page 'Search Page'
    When I click on Search Bar in search page 'Search Page'
    And I enter the wrong movie name input in search page 'Search Page'
    When I click on the search button in search page 'Search Page'
    Then I have verify the Number of Movies in the Failure Case of Search Page 'Search Page'
