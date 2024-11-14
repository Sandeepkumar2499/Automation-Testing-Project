Feature:  Popular page Test
  As a user of the movies website
  I should see all the popular movies
  in the popular section and
  Redirect to the movie details page.


  Scenario: Test the Popular Page UI
    Given I am on Login the page 'Popular Page'
    When  I enter the valid username and password for popular movies page 'Popular Page'
    And I click on the login button for popular movies 'Popular Page'
    And I click on popular page 'Popular Page'
    Then I have verify the movies are displayed or not in popular page 'Popular Page'