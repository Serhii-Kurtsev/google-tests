package pageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public WebDriver webDriver;


    @BeforeMethod
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        setDriver(webDriver);
    }

    public WebDriver getDriver() {
        return webDriver;
    }

    public void setDriver(WebDriver driver) {
        this.webDriver = driver;
    }

    @AfterMethod
    public void deleteDriver() {
        webDriver.quit();
    }
}
