package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MovieDetailsPage {
    public WebDriver driver;


    By usernameEl = By.id("usernameInput");
    By passwordEl = By.id("passwordInput");
    By loginButtonEl = By.className("login-button");

    public MovieDetailsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void loginToApplication(String username, String password){
        driver.findElement(usernameEl).sendKeys(username);
        driver.findElement(passwordEl).sendKeys(password);
        driver.findElement(loginButtonEl).click();
    }


    public Boolean movieDetailsPage_FindMovieTitle(){
        WebElement movieTitle = driver.findElement(By.className("movie-title"));
        return movieTitle.isDisplayed();
    }

    public boolean movieDetailsPage_MovieReview(){
        WebElement MovieReview = driver.findElement(By.className("movie-review-container"));
        return  MovieReview.isDisplayed();
    }

    public boolean movieDetailsPage_MovieOverview(){
        WebElement MovieOverview = driver.findElement(By.className("movie-overview"));
        return  MovieOverview.isDisplayed();
    }

    public boolean movieDetailsPage_MoviePlayButton(){
        WebElement MoviePlayButton = driver.findElement(By.className("play-button"));
        return  MoviePlayButton.isDisplayed();
    }

    public boolean movieDetailsPage_MovieCategories(){
        WebElement MovieCategories = driver.findElement(By.className("detailed-movie-categories-container"));
        return  MovieCategories.isDisplayed();
    }
}
