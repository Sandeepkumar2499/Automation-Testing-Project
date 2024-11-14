import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.AccountPage;

import java.time.Duration;

public class AccountPageTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public AccountPage accountPageTest;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\SANDEEP\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        accountPageTest = new AccountPage(driver);
        accountPageTest.loginToApplication("rahul","rahul@2021");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
    }


    @Test(priority = 1)
    public void testaccountpageUi(){
        accountPageTest.ClickOnaccountButton();
        String expectedUrl = "https://qamoviesapp.ccbp.tech/account";
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, currentUrl, "Navigate to account page failed");
        Assert.assertTrue(accountPageTest.findAccountNavBarSection(),"AccountsPage Header navBar section is not found");
        Assert.assertTrue(accountPageTest.findAccountDetailsSection(),"Accountspage AccountDetails section is not found");
    }

    @Test(priority = 2)
    public void testLogOutFunctionality(){

        accountPageTest.ClickOnaccountButton();
        accountPageTest.ClickOnaccountButton();
        String expectedUrl ="https://qamoviesapp.ccbp.tech/account";
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,currentUrl,"LogOut Function is not working");
    }



    @AfterMethod
    public void setdown(){
        driver.quit();
    }






}
