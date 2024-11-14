package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.testng.Assert;
import org.openqa.selenium.By;

public class HeaderFunctionalityStep {
    WebDriver driver = Hooks.getDriver();


    @Given ("I am on the login page in the Header Page 'Header Page'")
    public void iamontheloginpageheaderin_headerpage() {
        driver.get("https://qamoviesapp.ccbp.tech");
    }

    @When ("I have enter the valid Username and Password for Header Page 'Header Page'")
    public void ihaveenterthevalidusernameandpassword_headerpage() {
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
    }

    @And("I have click the login button Header Page 'Header Page'")
    public void iclickonloginbtn_headerpage() {
        driver.findElement(By.className ("login-button")).click();
    }


    @Then ("I have to check the logo and navBar's items are visibleHeader Page 'Header Page'")
    public void ihavetochecklogoandnavbarsvisibile_headerpage(){
        WebElement headerPg_logo=driver.findElement(By.className("website-logo"));
        Assert.assertTrue(headerPg_logo.isDisplayed(), "HeaderPg Logo is not displayed");

        WebElement HomeHeaderNavbar  =driver.findElement(By.linkText("Home"));
        WebElement HomeHeaderPopulareNavbar = driver.findElement(By.linkText("Popular"));
        WebElement HomeHeaderSearchNavbarNavbar= driver.findElement(By.className("search-empty-button"));
        WebElement HomeHeaderAccountNavbar = driver.findElement(By.className("avatar-button"));
        boolean are_visible =HomeHeaderNavbar.isDisplayed() && HomeHeaderPopulareNavbar.isDisplayed() && HomeHeaderSearchNavbarNavbar.isDisplayed() && HomeHeaderAccountNavbar.isDisplayed();
        Assert.assertTrue(are_visible,"Header Pg NavBar section is not working");
    }

    @And("I have to check home section in header page 'Header Page'")
    public void ihavetocheckhomesectionin_headerpage() {
        WebElement homeBarNavLink = driver.findElement(By.xpath("//a[contains(text(), 'Home')]"));
        homeBarNavLink.click();
        String homePageUrl = driver.getCurrentUrl();
        Assert.assertEquals(homePageUrl,"https://qamoviesapp.ccbp.tech/", "Home page url does not match");
    }

    @And("I have to check the popular section in header page 'Header Page'")
    public void ihavetocheckthepopularsectionin_headerpage() {
        WebElement popularNavLink = driver.findElement(By.xpath("//a[contains(text(), 'Popular')]"));
        popularNavLink.click();
        String popularPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(popularPageUrl,"https://qamoviesapp.ccbp.tech/popular","Popular page url does not match");
    }

    @Then ("I have to check the account section in header page 'Header Page'")
    public void ihavetochecktheaccountsectionin_headerpage() {
        WebElement accountBtn = driver.findElement(By.className("avatar-button"));
        accountBtn.click();
        String accountUrl = driver.getCurrentUrl();
        Assert.assertEquals(accountUrl, "https://qamoviesapp.ccbp.tech/account", "Account page url does not match");

    }

}