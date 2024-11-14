import Pages.MovieDetailsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class MovieDetailsPageTest {

    public WebDriver driver;
    public MovieDetailsPage moviedetailspage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\SANDEEP\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        moviedetailspage = new MovieDetailsPage(driver);
        moviedetailspage.loginToApplication("rahul","rahul@2021");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
    }

    @Test(priority=1)
    public void testMovieDetailsPageHomeUi(){
        WebElement HomePage = driver.findElement(By.xpath("/html/body/div/div/div[1]/nav/div[1]/ul/li[1]/a"));
        HomePage.click();

        WebElement HomePageAvatarMovie = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/a/div/img"));
        HomePageAvatarMovie.click();

        Assert.assertTrue(moviedetailspage.movieDetailsPage_FindMovieTitle(),"MovieDetailsPage Home Heading Title is not found");
        Assert.assertTrue(moviedetailspage.movieDetailsPage_MovieReview(),"MovieDeatilsPage Home MoviesReview is not found");
        Assert.assertTrue(moviedetailspage.movieDetailsPage_MovieOverview(),"MovieDetailsPage Home Movies OverView is not found");
        Assert.assertTrue(moviedetailspage.movieDetailsPage_MoviePlayButton(),"MovieDetailsPage Home PlayButton is not Working");
        Assert.assertTrue(moviedetailspage.movieDetailsPage_MovieCategories(),"MovieDetailsButton Home MovieCategories is not Displayed");

        WebElement popularpage = driver.findElement(By.linkText("Popular"));
        popularpage.click();

        WebElement popularPageNarnia = driver.findElement(By.xpath("/html/body/div/div/div[1]/li[16]/a/img"));
        popularPageNarnia.click();

        Assert.assertTrue(moviedetailspage.movieDetailsPage_FindMovieTitle(),"MovieDetailsPage Popular Heading Title is not found");
        Assert.assertTrue(moviedetailspage.movieDetailsPage_MovieReview(),"MovieDeatilsPage Popular MoviesReview is not found");
        Assert.assertTrue(moviedetailspage.movieDetailsPage_MovieOverview(),"MovieDetailsPage Popular Movies OverView is not found");
        Assert.assertTrue(moviedetailspage.movieDetailsPage_MoviePlayButton(),"MovieDetailsPage Popular PlayButton is not Working");
        Assert.assertTrue(moviedetailspage.movieDetailsPage_MovieCategories(),"MovieDetailsButton Popular MovieCategories is not Displayed");

    }

    @AfterMethod
    public void setdown(){
        driver.quit();
    }

}
