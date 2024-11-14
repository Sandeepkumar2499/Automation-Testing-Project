
import Pages.PopularPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class PopularPageTest {
    public static WebDriver driver;
    public PopularPage popularpage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\SANDEEP\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        popularpage = new PopularPage(driver);
        popularpage.loginToApplications("rahul","rahul@2021");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
    }

    @Test(priority = 1)
    public void testPopularPageUi(){

        WebElement popularPageButton = driver.findElement(By.linkText("Popular"));
        popularPageButton.click();

        String expectedUrl = "https://qamoviesapp.ccbp.tech/popular";

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String currentUrl = driver.getCurrentUrl();

        if(expectedUrl.equals(currentUrl)){
            System.out.println("The Movies are Displayed");
        }
        else{
            System.out.println("The Movies are not Displayed");
        }

    }

    @AfterMethod
    public void setdown(){
        driver.quit();
    }



}
