package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
    public  WebDriver driver;


    By UsernameLocator = By.id("usernameInput");
    By PasswordLocator = By.id("passwordInput");
    By loginButtonLocator = By.className("login-button");
    By accountsButtonEl = By.className("avatar-button");
    By accountNavHeaderEl=By.cssSelector(".nav-header");
    By accountDetailsEl = By.cssSelector(".account-information-container");
    By logoutButton = By.className("logout-button");


    public AccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    public void loginToApplication(String username, String password){
        driver.findElement(UsernameLocator).sendKeys(username);
        driver.findElement(PasswordLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
    }

    public void ClickOnaccountButton(){
        driver.findElement(accountsButtonEl).click();
    }

    public boolean findAccountNavBarSection(){
        return driver.findElement(accountNavHeaderEl).isDisplayed();
    }

    public boolean findAccountDetailsSection(){
        return driver.findElement(accountDetailsEl).isDisplayed();
    }

    public void ClickOnLogOutButton(){
        driver.findElement(logoutButton).click();
    }

}
