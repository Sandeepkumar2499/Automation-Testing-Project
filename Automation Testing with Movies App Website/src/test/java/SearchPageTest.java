import Pages.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;


public class SearchPageTest {
    public static WebDriver driver;
    public SearchPage searchpage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\SANDEEP\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        searchpage = new SearchPage(driver);
        searchpage.loginToApplication("rahul","rahul@2021");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
    }



    @Test(priority = 1)
    public void testSearchPageFunctionality(){

        WebElement searchButtonEl = driver.findElement(By.className("search-empty-button"));
        searchButtonEl.click();

        WebElement searchInputEl = driver.findElement(By.id("search"));
        searchInputEl.sendKeys("Avatar");

        WebElement searchButtonEls = driver.findElement(By.className("search-button"));
        searchButtonEls.click();

        List<WebElement> moviesfindEl = driver.findElements(By.className("movie-icon-item"));

        if(moviesfindEl.size()==1){
            System.out.println("Movies Search functions Number-of-movies : " + moviesfindEl.size());
        }

        else{
            System.out.println("Movies Search functions are not working");
        }
    }

    @Test(priority = 2)
    public void testSearchFunctionalitywithFailureCase(){
        WebElement searchButtonEl = driver.findElement(By.className("search-empty-button"));
        searchButtonEl.click();

        WebElement searchInputEl = driver.findElement(By.id("search"));
        searchInputEl.sendKeys("Nemo");

        WebElement searchButtonEls = driver.findElement(By.className("search-button"));
        searchButtonEls.click();

        WebElement errorImageEl = driver.findElement(By.className("not-found-search-image"));

        WebElement errortextEl = driver.findElement(By.className("not-found-search-paragraph"));

        boolean is_bothErrorDisplayed = errorImageEl.isDisplayed() && errortextEl.isDisplayed();

        if(is_bothErrorDisplayed){
            System.out.println("Search Functionality with Failure Case is working");
        }

        else{
            System.out.println("Search Functionality with Failure Case is not working");
        }


    }

    @AfterMethod
    public void setdown(){
        driver.quit();
    }

}
