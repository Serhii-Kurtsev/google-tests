package pageObject;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchImageOpenLink extends BaseTest {
    @Test
    public void searchSeveralImagesAndOpenLink() {
        getDriver().get("https://www.google.com/");
        new GoogleSearchPageObject(webDriver)
                .sendSearchQueryAndSubmit("car")
                .switchToImagesTab()
                .clickToolsButton()
                .setLargeSize()
                .setBlackAndWhiteColor()
                .setClipArtType()
                .clickThrough5Images()
                .clickOnVisitButton()
                .switchToSecondTab();
        Assert.assertNotEquals(webDriver.getTitle(), "car - Google Search");
    }
}
