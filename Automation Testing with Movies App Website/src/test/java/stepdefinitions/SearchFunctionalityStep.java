package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SearchFunctionalityStep {
    WebDriver driver = Hooks.getDriver();

    @Given("I am on Login the page in the Search Page 'Search Page'")
    public void iamontheloginpage_SearchPage(){
        driver.get("https://qamoviesapp.ccbp.tech");
    }

    @When("I enter the valid username and password for Search Page 'Search Page'")
    public void ienterthevalidusernameandpassword_searchpage(){
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
    }

    @And("I click on the login button for Search Page 'Search Page'")
    public void iclickonloginbutton_searchpage() {
        driver.findElement(By.className ("login-button")).click();
    }

    @When("I click on Search Bar in search page 'Search Page'")
    public void iclickonsearchbarin_searchpage(){
        driver.findElement(By.className("search-empty-button")).click();
    }

    @And("I enter the valid movie name in the Seacrh Page 'Search Page'")
    public void ientervalidmovienamein_searchpage(){
        driver.findElement(By.id("search")).sendKeys("Avatar");
    }

    @When("I click on the search button in search page 'Search Page'")
    public void iclickonseacrhbuttonin_searchpage(){
        driver.findElement(By.className("search-button")).click();
    }

    @Then("I have verify the Number of Movies in the Search Page 'Search Page'")
    public void ihaveverifythenumberofmoviesin_searchpage(){
        List<WebElement> moviesfindEl = driver.findElements(By.className("movie-icon-item"));

        if(moviesfindEl.size()==1){
            System.out.println("Movies Search functions Number-of-movies : " + moviesfindEl.size());
        }

        else{
            System.out.println("Movies Search functions are not working");
        }
    }

    @And("I enter the wrong movie name input in search page 'Search Page'")
    public void ienterthewrongmoviename_searchpage(){
        driver.findElement(By.id("search")).sendKeys("Nemo");
    }

    @Then("I have verify the Number of Movies in the Failure Case of Search Page 'Search Page'")
    public void ihaveverifythenumberofmoviesinfailiurecase_searchpage(){
        WebElement errorImageEl = driver.findElement(By.className("not-found-search-image"));
        WebElement errortextEl = driver.findElement(By.className("not-found-search-paragraph"));
        boolean is_bothErrorDisplayed = errorImageEl.isDisplayed() && errortextEl.isDisplayed();
        Assert.assertTrue(is_bothErrorDisplayed,"Search Functionality with Failure Case is not working");

    }


}
