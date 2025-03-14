import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class TestAutomationPractice extends Base{


    @FindBy(css = ".wikipedia-search-input")
    WebElement searchBox;

    @FindBy(xpath = "//div[@id=\"wikipedia-search-result-link\"]/a[1]")
    WebElement firstResult;

    void searchBoxTab(String book){
        String startingPage = driver.getWindowHandle();
        searchBox.sendKeys(book, Keys.ENTER);
        explicitWaitVisibile(firstResult,3);
        firstResult.click();
        handleTabsAndWindows(startingPage); // switches to the wikipedia page
        Assert.assertEquals(driver.getCurrentUrl(),"https://en.wikipedia.org/wiki/The_Catcher_in_the_Rye");
    }

    @FindBy (xpath = "//h2[contains(text(),'SVG Elements')]")
    WebElement header;

    @FindBy(xpath = "//div[@id=\"draggable\"]")
    WebElement dragThis;

    @FindBy(xpath = "//div[@id=\"droppable\"]")
    WebElement target;

    @FindBy(xpath = "//p[contains(text(),'Dropped!')]")
    WebElement expectedPText;

    void dnd(){
        scrollToElem(header);
        impWait(3);
        dragdrop(dragThis,target);
        impWait(3);
        Assert.assertTrue(expectedPText.isDisplayed());
        String expectedColor = target.getCssValue("background-color"); // rgba(255, 250, 144, 1)
        Assert.assertEquals(expectedColor,"rgba(255, 250, 144, 1)");
    }



}
