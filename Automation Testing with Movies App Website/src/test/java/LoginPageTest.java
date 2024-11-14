import Pages.LoginPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations. BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageTest {
    public WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\SANDEEP\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
    }

    @Test(priority = 1)
    public void testLoginPgUi() {
        boolean logo = loginPage.LoginPage_findLogo();
        if (logo) {
            System.out.println("LoginPage Logo checked successfully");
        } else {
            System.out.println("LoginPage Logo checked !Failed");
        }
        String headingTxt = loginPage.LoginPage_GetHeading();
        Assert.assertEquals (headingTxt,"Login", "LoginPage heading does not match");
        Assert.assertEquals (loginPage.LoginPage_GetUserNameLabel(), "USERNAME", "LoginPage username label not match");
        Assert.assertEquals (loginPage.LoginPage_PasswordLabel(), "PASSWORD", "LoginPg password label not match");
        Assert.assertTrue(loginPage.LoginPage_textLoginButton(), "LoginPage loginBtn is not Working");
    }

    @Test (priority = 2)
        public void testLoginPgWithEmptyInputs(){
        loginPage.loginToApplication ( "", "");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds (10));
        String errorMsg = loginPage.loginPage_GetErrorMesge();
        Assert.assertEquals(errorMsg, "*Username or password is invalid", "Login empty input fields does not");

    }

    @Test(priority = 3)
    public void testLoginPgWithEmptyUserName() {
        loginPage.loginToApplication ( "", "rahul@2021");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        String errorMsg = loginPage.loginPage_GetErrorMesge();
        Assert.assertEquals (errorMsg, "*Username or password is invalid", "LoginPage empty username fields does match");
    }

    @Test (priority = 4)
    public void testLoginPgWithEmptyPassword() {
        loginPage.loginToApplication ( "rahul",  "");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        String errorMsg = loginPage.loginPage_GetErrorMesge();
        Assert.assertEquals(errorMsg, "*Username or password is invalid", "LoginPage empty password fields does ");
    }

    @Test (priority = 5)
    public void testLoginPgWithInvalidCredentials () {
        loginPage.loginToApplication ( "rahul", "rahu12021");
        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds (10));
        String errorMsg = loginPage.loginPage_GetErrorMesge();
        Assert.assertEquals(errorMsg, "*username and password didn't match", "Login Page with InvalidCredentials");
    }


    @Test (priority = 6)
    public void testLoginPgWithValidCredentials(){
        loginPage.loginToApplication ("rahul", "rahul@2021");

    }

    @AfterMethod
    public void setdown(){
        driver.quit();
    }
}