Feature: MovieDetails Page Test
  As a user of the movies website
  I should see all the popular movies
  in the popular section and
  Redirect to the movie details page.



  Scenario: Test the Movie Details Page
    Given I am on the login page for movieDetail Page 'movieDetail Page'
    When I enter the Valid user credential MovieDetailsPage 'movieDetail Page'
    And I click on the loginButton movieDetail Page 'movieDetail Page'
    When I click on home movieDetail Page 'movieDetail Page'
    And I click on any movie in home section movieDetail Page 'movieDetail Page'
    When I have to verify the home movie ui elements movieDetail Page 'movieDetail Page'
    When I click on popular movieDetail Page 'movieDetail Page'
    And I click on any movie in popular section movieDetail Page 'movieDetail Page'
    Then I have to verify the popular movie ui elements movieDetail Page 'movieDetail Page'