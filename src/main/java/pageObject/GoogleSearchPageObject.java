package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleSearchPageObject extends BasePage {

    public GoogleSearchPageObject(WebDriver webDriver) {
        super(webDriver);
    }

    private final By searchBox = By.xpath("//input[@aria-label='Search']");
    private final By imagesTopNavigationLink = By.xpath("//div[@id='top_nav']/descendant::*[text()='Images']");
    private final By toolsButton = By.xpath("//div[text()='Tools']");
    private final By sizeToolsButton = By.xpath("//div[@aria-label='Size']");
    private final By largeSizeOptionInTools = By.xpath("//span[text()='Large']");
    private final By colorToolsButton = By.xpath("//div[@aria-label='Color']");
    private final By blackAndWhiteOptionInTools = By.xpath("//span[text()='Black and white']");
    private final By typeToolsButton = By.xpath("//div[@aria-label='Type']");
    private final By clipArtTypeOptionInTools = By.xpath("//span[text()='Clip Art']");
    private final By anyImageOnSearchResultPage = By.xpath("//div[@data-ri]");
    private final By visitSideBarButton = By.xpath("//span[text()='Visit']");

    public GoogleSearchPageObject sendSearchQueryAndSubmit(String input) {
        waitForVisible(searchBox, 10);
        setKeys(searchBox, input + Keys.ENTER);
        log("Search query " + input);
        return this;
    }

    public GoogleSearchPageObject switchToImagesTab() {
        javaScriptClick(imagesTopNavigationLink);
        log("Clicking images");
        return this;
    }

    public GoogleSearchPageObject clickToolsButton() {

        javaScriptClick(toolsButton);
        log("Open Tools menu");
        return this;
    }

    public GoogleSearchPageObject setLargeSize() {
        waitForVisible(sizeToolsButton, 10);
        javaScriptClick(sizeToolsButton);
        waitForVisible(largeSizeOptionInTools, 10);
        javaScriptClick(largeSizeOptionInTools);
        log("Set images Large size");
        return this;
    }

    public GoogleSearchPageObject setBlackAndWhiteColor() {
        javaScriptClick(colorToolsButton);
        waitForVisible(blackAndWhiteOptionInTools, 10);
        javaScriptClick(blackAndWhiteOptionInTools);
        log("Set images Black and White color");
        return this;
    }

    public GoogleSearchPageObject setClipArtType() {
        javaScriptClick(typeToolsButton);
        waitForVisible(clipArtTypeOptionInTools, 10);
        javaScriptClick(clipArtTypeOptionInTools);
        log("Set images Clip Art type");
        return this;
    }

    public GoogleSearchPageObject clickThrough5Images() {
        List<WebElement> listOfImages = webDriver.findElements(anyImageOnSearchResultPage);
        for (int i = 0; i < 6; i++) {
            clickInCollection(listOfImages.get(i));
        }
        log("Switch between 5 images");
        return this;
    }

    public GoogleSearchPageObject clickOnVisitButton() {
        javaScriptClick(visitSideBarButton);
        log("Click on the 'Visit' button and open a new tab");
        return this;
    }

}
