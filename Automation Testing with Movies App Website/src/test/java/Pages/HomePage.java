package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class HomePage {
    public WebDriver driver;

    By UsernameLocator = By.id("usernameInput");
    By PasswordLocator = By.id("passwordInput");
    By loginButtonLocator = By.className("login-button");
    By HomeHeadingTextLocator = By.className("home-movie-heading");

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String GetHomePageHeading(){
        WebElement homeTextEle = driver.findElement(HomeHeadingTextLocator);
        String HomeText = homeTextEle.getText();
        return HomeText;
    }

    public boolean CheckHomePagePlayButton (){
        WebElement Homepage_buttonEl = driver.findElement(By.className("home-movie-play-button"));
        return Homepage_buttonEl.isEnabled();
    }

    public boolean checkHomePageContactUsSection(){
        WebElement hompage_GoogleSym = driver.findElement(By.className("google-icon"));
        WebElement hompage_TwitterSym = driver.findElement(By.className("twitter-icon"));
        WebElement hompage_IntaSym = driver.findElement(By.className("instagram-icon"));
        WebElement hompage_YoutubeSym = driver.findElement(By.className("youtube-icon"));
        WebElement hompage_ContactUsym = driver.findElement(By.className("contact-us-paragraph"));

        boolean contactUsSymareVisible = hompage_GoogleSym.isDisplayed() && hompage_TwitterSym.isDisplayed() && hompage_IntaSym.isDisplayed() && hompage_YoutubeSym.isDisplayed();
        if (contactUsSymareVisible)
            return contactUsSymareVisible;

        return hompage_ContactUsym.isDisplayed();

    }

    public boolean checkHomePageMovieSection(){
        List<WebElement> homepage_trendingSection = driver.findElements(By.xpath("/html/body/div/div/div[2]/div[1]/div/div"));
        List<WebElement> homepage_OriginalSection = driver.findElements(By.xpath("/html/body/div/div/div[2]/div[2]/div/div"));
        return !homepage_trendingSection.isEmpty() && !homepage_OriginalSection.isEmpty();

    }

    public void loginToApplication(String username, String password){
        driver.findElement(UsernameLocator).sendKeys(username);
        driver.findElement(PasswordLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
    }

}
