package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10), Duration.ofMillis(200));
    }

    public boolean isRegistrationPage(){
        try{
            By welcomeLocator = By.cssSelector("//*[@class='title']");
            wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeLocator));
            driver.findElement(welcomeLocator);
            return true;
        }  catch(TimeoutException e){
            return false;
        }
    }
}
