package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    public WebDriver driver;
    public WebDriverWait wait;

    @FindBy(className = "sign-in-heading")
    WebElement loginpage_HeadingEl;

    @FindBy(id = "usernameInput")
    WebElement loginpage_UserNameEl;

    @FindBy(id = "passwordInput")
    WebElement loginpage_PasswordEl;

    @FindBy(className = "login-button")
    WebElement loginpage_LoginButtonEl;

    @FindBy(className = "error-message")
    WebElement loginpage_ErrorMsgEl;

    WebElement loginpage_logoEl;

    WebElement loginpage_UserNameLabelEl;

    WebElement loginpage_PasswordLabelEl;

    public  LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
        loginpage_logoEl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login-button")));
        loginpage_UserNameLabelEl = driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[1]/label"));
        loginpage_PasswordLabelEl = driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[2]/label"));
    }

    public  boolean LoginPage_findLogo(){
        return loginpage_logoEl.isDisplayed();
    }

    public String LoginPage_GetHeading(){
        return  loginpage_HeadingEl.getText();
    }

    public String LoginPage_GetUserNameLabel(){
        return  loginpage_UserNameLabelEl.getText();
    }

    public String LoginPage_PasswordLabel(){
        return  loginpage_PasswordLabelEl.getText();
    }

    public  boolean LoginPage_textLoginButton(){
        boolean is_buttonEnabled = loginpage_LoginButtonEl.isEnabled() && loginpage_LoginButtonEl.isDisplayed();
        return is_buttonEnabled;
    }

    public  String loginPage_GetErrorMesge (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        return loginpage_ErrorMsgEl.getText();
    }

    public void loginToApplication(String username, String password){
        loginpage_UserNameEl.sendKeys (username);
        loginpage_PasswordEl.sendKeys (password);
        loginpage_LoginButtonEl.click();
    }

}
