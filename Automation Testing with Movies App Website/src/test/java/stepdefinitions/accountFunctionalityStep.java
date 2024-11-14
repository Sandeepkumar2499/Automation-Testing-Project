package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;


public class accountFunctionalityStep {
    WebDriver driver = Hooks.getDriver();


    @Given ("I am on the login page in 'Account Page'")
    public void iamonloginpagein_accountpage(){
        driver.get("https://qamoviesapp.ccbp.tech");
    }

    @When("I have enter the valid Username and Password in the 'Account Page'")
    public void ihaveenterthevalidusernameandpasswordin_accountpage() {
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
    }

    @And("I have click on the loginbutton in the 'Account Page'")
    public void ihaveclickthrloginbtn_accountpage(){
        driver.findElement(By.className("login-button")).click();
    }

    @When("I have click on account section in 'Account Page'")
    public void ihaveclickonaccountsection_accountpage() {
        driver.findElement(By.className("avatar-button")).click();
    }

    @And("I have to verify the account page navigation 'Account Page'")
    public void ihavetoverifytheaccountpagenavigation_accountpage() {
        String expectedUrlAccounPg = "https://qamoviesapp.ccbp.tech/account";
        String currentUrlAccount = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrlAccounPg, currentUrlAccount,"Navigation to account page failed");
    }

    @When("I have to verify the NavBar section 'Account Page'")
    public void iahvetoverifythenavbarsection_accountpage() {
        WebElement is_nabarSection_Displayed = driver.findElement(By.className("nav-header"));
        Assert.assertTrue(is_nabarSection_Displayed.isDisplayed (), "NavBar section for account Page is not found");
    }


    @Then("I have to verify the account section 'Account Page'")
    public void ihavetoverifyaccountsectionpage_accountpage() {
        WebElement is_accountSection_Displayed = driver.findElement(By.className ("account-information-container"));
        Assert.assertTrue(is_accountSection_Displayed.isDisplayed (), "Account details for account page is not found");
    }

    @When("I click on the logout button 'Account Page'")
    public void iclickonthelogoutbutton_accountpage() {
        driver.findElement(By.xpath("/html/body/div/div/div[1]/div[3]/button")).click();
    }


    @Then("I have to redirect to the login page 'Account Page'")
    public void ihavetoredirecttheloginpage_accountpage(){
        String expectedLoginUrl = "https://qamoviesapp.ccbp.tech/login";
        String currentLoginUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedLoginUrl,currentLoginUrl,"Logout Function is not working");
    }


}

