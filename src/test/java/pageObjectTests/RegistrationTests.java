package pageObjectTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;

import java.time.Instant;

public class RegistrationTests {
    private WebDriver driver;
    private String url;

    @BeforeMethod
    public void startUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        url = "https://parabank.parasoft.com/parabank/index.htm";
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void loginToAccount_correctCredentials_successfulLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
        //Thread.sleep(3000);

        RegistrationPage registrationPage = loginPage.clickRegister();
        Assert.assertTrue(registrationPage.isRegistrationPage());
    }
}
