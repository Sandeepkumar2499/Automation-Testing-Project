
import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class HomePageTest {
    public WebDriver driver;
    public HomePage homepageTest;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\SANDEEP\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        homepageTest = new HomePage(driver);
        homepageTest.loginToApplication("rahul", "rahul@2021");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
    }

    @Test(priority = 1)
    public void testHomepage(){
        Assert.assertEquals(homepageTest.GetHomePageHeading(),homepageTest.GetHomePageHeading(),"HomePage Heading not found");

        Assert.assertTrue(homepageTest.CheckHomePagePlayButton(),"Play Button is not working");

        Assert.assertTrue(homepageTest.checkHomePageMovieSection(),"Movies are not displayed in the corresponding movie");

        Assert.assertTrue(homepageTest.checkHomePageContactUsSection(),"Contact Us section is not displayed");
    }

    @AfterMethod
    public void setdown(){
        driver.quit();
    }

}
