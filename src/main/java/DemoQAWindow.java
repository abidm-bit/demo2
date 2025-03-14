import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DemoQAWindow extends Base{


    @FindBy(css="#windowButton")
    WebElement newWindow;

   @FindBy(id = "sampleHeading") WebElement heading;

    void newWindowM(){
        String starting = driver.getWindowHandle();
        explicitWaitVisibile(newWindow,5);
        newWindow.click();
        handleTabsAndWindows(starting); // switch to the window
        String actualText = heading.getText();
        String expectedText = "This is a sample page";
        Assert.assertEquals(actualText,expectedText);
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/sample");
        String secondWindow = driver.getWindowHandle();
        driver.close(); // closes the window
        handleTabsAndWindows(secondWindow);
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/browser-windows");
    }




}
