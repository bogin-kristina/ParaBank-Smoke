package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10), Duration.ofMillis(200));
    }

    public void open(String url) {

        driver.get(url);
    }

    private WebElement getRegisterButton(){
        By registerLocator = By.xpath("//*[@href='register.htm']");
        wait.until(ExpectedConditions.elementToBeClickable(registerLocator));
        return driver.findElement(registerLocator);
    }

    public RegistrationPage clickRegister(){
        getRegisterButton().click();
        return new RegistrationPage(driver);
    }


}
