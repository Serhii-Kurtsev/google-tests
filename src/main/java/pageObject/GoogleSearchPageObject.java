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
        return this;
    }

    public GoogleSearchPageObject switchToImagesTab() {
        click(imagesTopNavigationLink);
        return this;
    }

    public GoogleSearchPageObject clickToolsButton() {

        click(toolsButton);
        return this;
    }

    public GoogleSearchPageObject setLargeSize() {
        waitForVisible(sizeToolsButton, 10);
        javaScriptClick(sizeToolsButton);
        waitForVisible(largeSizeOptionInTools, 10);
        click(largeSizeOptionInTools);
        return this;
    }

    public GoogleSearchPageObject setBlackAndWhiteColor() {
        click(colorToolsButton);
        waitForVisible(blackAndWhiteOptionInTools, 10);
        click(blackAndWhiteOptionInTools);
        return this;
    }

    public GoogleSearchPageObject setClipArtType() {
        click(typeToolsButton);
        waitForVisible(clipArtTypeOptionInTools, 10);
        click(clipArtTypeOptionInTools);
        return this;
    }

    public GoogleSearchPageObject clickThrough5Images() {
        List<WebElement> listOfImages = webDriver.findElements(anyImageOnSearchResultPage);
        for (int i = 0; i < 6; i++) {
            clickInCollection(listOfImages.get(i));
        }
        return this;
    }

    public GoogleSearchPageObject clickOnVisitButton() {
        javaScriptClick(visitSideBarButton);
        return this;
    }

}
