
import Pages.HeaderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class HeaderPageTest {
    public static WebDriver driver;
    public HeaderPage headerPageTest;


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\SANDEEP\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        headerPageTest = new HeaderPage(driver);
        headerPageTest.loginToApplication ("rahul", "rahul@2021");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds (10));
    }


    @Test (priority = 1)
    public void testHeaderSectionUi() {
        Assert.assertTrue(headerPageTest.findHomeHeaderLogo(), "HomePage logo is not found");


        Assert.assertTrue (headerPageTest.findHomeHeaderNavbar (), "Home Page NavBar is not working");
        Assert.assertTrue (headerPageTest.findHomeHeaderPopulareNavbar (),  "Popular NavBar is not working");
        Assert.assertTrue (headerPageTest.findHomeHeaderAccountNavbar (), "Account NavBar is not working");
        Assert.assertTrue (headerPageTest.findHomeHeaderSearchNavbar (),  "Search NavBar is not working");
    }


    @Test (priority=2)
    public void testHeaderSectionFunctionalities() {
        WebElement homeNavLink = driver.findElement(By.xpath("//a[contains (text(), 'Home')]"));

        homeNavLink.click();
        String homePageUrl= driver.getCurrentUrl();

        Assert.assertEquals (homePageUrl,  "https://qamoviesapp.ccbp.tech/",  "Home page url does not match");

        WebElement popularNavLink = driver.findElement(By.xpath("//a[contains(text (), 'Popular')]"));

        popularNavLink.click();
        String popularPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(popularPageUrl, "https://qamoviesapp.ccbp.tech/popular",  "Popular page url does not match");

        WebElement accountBtn = driver.findElement(By.className ("avatar-button"));
        accountBtn.click();
        String accountUrl= driver.getCurrentUrl();
        Assert.assertEquals (accountUrl, "https://qamoviesapp.ccbp.tech/account", "Account page url does not match");

    }

    @AfterMethod
    public void setdown(){
        driver.quit();
    }


}
