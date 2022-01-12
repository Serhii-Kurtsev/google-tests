package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class BasePage {

    protected WebDriver webDriver;


    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void setKeys(By locator, String input) {
        webDriver.findElement(locator).sendKeys(input);
    }

    public void waitForVisible(By locator, int timeWait) {

        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(timeWait));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void javaScriptClick(By locator) {
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("arguments[0].click();", webDriver.findElement(locator));
    }

    public void clickInCollection(WebElement element) {
        element.click();
    }

    public void switchToSecondTab() {
        ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(1));
    }

    protected void log(String log) {
        System.out.println(log);
    }

}
