package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;

public class HeaderPage{
    public WebDriver driver;

    By userNameLocator =By.id("usernameInput");

    By passwordLocator =By.id("passwordInput");

    By LoginButton = By.className("login-button");

    public HeaderPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void loginToApplication(String username, String password){
        driver.findElement(userNameLocator).sendKeys (username);
        driver.findElement(passwordLocator).sendKeys (password);
        driver.findElement(LoginButton).click();
    }

    public boolean findHomeHeaderLogo(){

        WebElement homepageLogo= driver.findElement(By.className("website-logo"));
        return homepageLogo.isDisplayed();

    }

    public boolean findHomeHeaderNavbar(){
        WebElement homepage_NavbarEl = driver.findElement(By.linkText("Home"));
        return homepage_NavbarEl.isDisplayed();
    }
    public boolean findHomeHeaderPopulareNavbar(){
        WebElement homepagePopularNavbarEl= driver.findElement(By.linkText("Popular"));
        return homepagePopularNavbarEl.isDisplayed();

    }


    public boolean findHomeHeaderAccountNavbar(){

        WebElement homePage_AccountNavbarEl = driver.findElement(By.className("avatar-button"));
        return  homePage_AccountNavbarEl.isDisplayed();
    }

    public boolean findHomeHeaderSearchNavbar(){
        WebElement homepageSearchNavbarEl = driver.findElement(By.className("search-empty-button"));
        return homepageSearchNavbarEl.isDisplayed();
    }

}
