package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    public  WebDriver driver;


    By UsernameLocator = By.id("usernameInput");
    By PasswordLocator = By.id("passwordInput");
    By loginButtonLocator = By.className("login-button");

    public SearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    public void loginToApplication(String username, String password){
        driver.findElement(UsernameLocator).sendKeys(username);
        driver.findElement(PasswordLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
    }



}
