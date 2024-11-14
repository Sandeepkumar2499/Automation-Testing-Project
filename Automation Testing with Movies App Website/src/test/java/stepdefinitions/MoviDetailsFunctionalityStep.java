package stepdefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.WebElement;

public class MoviDetailsFunctionalityStep {
    WebDriver driver = Hooks.getDriver();

    @Given("I am on the login page for movieDetail Page 'movieDetail Page'")
    public void iamontheloginpagefor_moviedetailpage(){
        driver.get("https://qamoviesapp.ccbp.tech");
    }


    @When("I enter the Valid user credential MovieDetailsPage 'movieDetail Page'")
    public void ientervalidusernameandpassword_MovieDetailsPg() {
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
    }


    @And("I click on the loginButton movieDetail Page 'movieDetail Page'")
    public void iclickonloginBtn_MovieDetailsPage() {
        driver.findElement(By.className("login-button")).click();
    }

    @When("I click on home movieDetail Page 'movieDetail Page'")
    public void iclickonhome_MovieDetailsPage() {
        driver.findElement(By.xpath("/html/body/div/div/div[1]/nav/div[1]/ul/li[1]/a")).click();
    }

    @And("I click on any movie in home section movieDetail Page 'movieDetail Page'")
    public void iclickanymovieinhomesection_movidetailspage() {
        WebElement imaxMovie = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/div/div/div[1]/div/a/div/img"));
        imaxMovie.click();
    }

    @When("I have to verify the home movie ui elements movieDetail Page 'movieDetail Page'")
    public void ihavetoverifythehomemovieuielements_movidetailspage() {
        WebElement movieHeading = driver.findElement(By.className("movie-title"));
        WebElement movieReview = driver.findElement(By.className("movie-review-container"));
        WebElement movieOverView = driver.findElement(By.className("movie-overview"));
        WebElement moviePlayBtn = driver.findElement(By.className("play-button"));
        WebElement movieCategories = driver.findElement(By.className("detailed-movie-categories-container"));


        Assert.assertTrue(movieHeading.isDisplayed(), "Movie Details Pg Home heading is not found");
        Assert.assertTrue(movieReview.isDisplayed(), "MovieDetailsPg Home movies review is not found");
        Assert.assertTrue(movieOverView.isDisplayed(), "MovieDetailsPg Home movies overview is not found");
        Assert.assertTrue(moviePlayBtn.isDisplayed(), "MovieDetailsPg Home playBtn is not found");
        Assert.assertTrue(movieCategories.isDisplayed(), "MovieDetailsPg Home movies categories is not found");

    }

    @When("I click on popular movieDetail Page 'movieDetail Page'")
    public void iclickonpopular_moviedetailspage() {
        driver.findElement(By.xpath("/html/body/div/div/div[1]/nav/div[1]/ul/li[2]/a")).click();
    }

    @And("I click on any movie in popular section movieDetail Page 'movieDetail Page'")
    public void iclickonanymoviepopularsection_MovieDetailsPage() {
        WebElement lucaMovie = driver.findElement(By.xpath("/html/body/div/div/div[1]/li[4]/a/img"));
        lucaMovie.click();
    }

    @Then("I have to verify the popular movie ui elements movieDetail Page 'movieDetail Page'")
    public void ihavetoverifypopularmovieui_MoviDetailsPage() {
        WebElement movieHeading = driver.findElement(By.className("movie-title"));
        WebElement movieReview = driver.findElement(By.className("movie-review-container"));
        WebElement movieOverView = driver.findElement(By.className("movie-overview"));
        WebElement moviePlayBtn = driver.findElement(By.className("play-button"));
        WebElement movieCategories = driver.findElement(By.className("detailed-movie-categories-container"));

        Assert.assertTrue(movieHeading.isDisplayed(), "Movie Details Pg Popular heading is not found");
        Assert.assertTrue(movieReview.isDisplayed(), "Movie Details Pg Popular movies review is not found");
        Assert.assertTrue(movieOverView.isDisplayed(), "Movie Details Pg Popular movies overview is not found");
        Assert.assertTrue(moviePlayBtn.isDisplayed(), "Movie Details Pg Popular playBtn is not found");
        Assert.assertTrue(movieCategories.isDisplayed(), "Movie DetailsPg Popular movies categories is not found");

    }
}
