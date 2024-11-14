import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import stepdefinitions.Hooks;

import java.time.Duration;


public class PopularFunctionalityStep {

    WebDriver driver = Hooks.getDriver();

    @Given("I am on Login the page 'Popular Page'")
    public void iamontheloginpage_popularpage() {
        driver.get("https://qamoviesapp.ccbp.tech");
    }

    @When("I enter the valid username and password for popular movies page 'Popular Page'")
    public void ientervalidusernameandpassword_popularpage() {
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
    }

    @And("I click on the login button for popular movies 'Popular Page'")
    public void iclickonloginbutton_popularpage() {
        driver.findElement(By.className ("login-button")).click();
    }


    @When ("I click on popular page 'Popular Page'")
    public void iclickonpopularpage_popularpage() {
        driver.findElement(By.xpath("/html/body/div/div/div[1]/nav/div[1]/ul/li[2]/a")).click();
    }

    @Then("I have verify the movies are displayed or not in popular page 'Popular Page'")
    public void ihavetoverifymoviesvisibleornot_popularpage(){
        WebElement popularpage = driver.findElement(By.linkText("Popular"));
        popularpage.click();

        String expectedUrl = "https://qamoviesapp.ccbp.tech/popular";

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String currentUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,currentUrl,"Popular movies page are not displayed");
    }


}
