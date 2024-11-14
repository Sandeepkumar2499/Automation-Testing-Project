package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

public class LoginFunctionalityStep {

    WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("I am on the login page in the Login Page 'Login Page'")
    public void iamonloginpage_loginpage() {
        driver.get("https://qamoviesapp.ccbp.tech");
    }

    @Then("I have Verify all the content in the Login Page 'Login Page'")
    public void ihaveverifyallthecontentinthe_loginpage() {

        boolean websiteLogo_loginPg = driver.findElement(By.className("login-website-logo")).isDisplayed();
        Assert.assertTrue(websiteLogo_loginPg, "Login Pg logo is not found");

        String heading_loginPg = driver.findElement(By.className("sign-in-heading")).getText();
        Assert.assertEquals(heading_loginPg, "Login", "LoginPg heading not match");

        String userNamelabelTxt_loginPg = driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[1]/label")).getText();
        Assert.assertEquals(userNamelabelTxt_loginPg, "USERNAME", "LoginPg userNameLabel text not match");

        String passwordLabelTxt_loginPg = driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[2]/label")).getText();
        Assert.assertEquals(passwordLabelTxt_loginPg, "PASSWORD", "Login Pg");
    }


    @When("I click on the Login Button in the Login Page 'Login Page'")
    public void iclickontheloginpagebutton_loginpage() {
        driver.findElement(By.className("login-button")).click();
    }

    @When("I enter the Valid Username in the Login Page 'Login Page'")
    public void ienterthevalidusernameinthe_loginpage() {
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
    }

    @When ("I enter the Valid Password in the Login Page 'Login Page'")
    public void ienterthevalidpasswordinthe_loginpage() {
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
    }

    @When("I enter the Wrong Password in the Login Page 'Login Page'")
    public void ienterthewrongpasswordinthe_loginpage() {
        driver.findElement(By.id("passwordInput")).sendKeys("rabul2021");
    }

    @Then ("I have to verify the error text 'Invalid Credintials Field' in the Login Page 'Login Page'")
    public void iverifytheerrortxtemptyinput_loginPage() {
        String ErrorText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message"))).getText();
        Assert.assertEquals (ErrorText,"*username and password didn't match");
    }

    @Then("I have to verify the error text 'Empty UserName Field' in the Login Page 'Login Page'")
    public void ihavetoverifyemptyusername_loginpage(){
        String ErrorTextUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message"))).getText();
        Assert.assertEquals(ErrorTextUsername,"*Username or password is invalid");
    }

    @Then("I have to verify the error text 'Empty Password Field' in the Login Page 'Login Page'")
    public void ihavetoverifyemptypassword_loginpage(){
        String ErrorTextUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message"))).getText();
        Assert.assertEquals(ErrorTextUsername,"*Username or password is invalid");
    }

}