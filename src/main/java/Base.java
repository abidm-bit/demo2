import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Base {

    static WebDriver driver;


    // driver.get() // all elements to be loaded
    void getSite1(String url){
        driver= new ChromeDriver();
        driver.get(url);
    }


    // driver.navigate().to()
    // keeps the page history , but it doesn't wait for all elements to be loaded
    // implicit wait or explicit wait
    void getSite2(String url){
        driver = new ChromeDriver();
        driver.navigate().to(url);
    }

    // implicit wait : it waits for all elements in a page to be loaded
    void impWait(int seconds){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    // explicit wait: a condition, such as the visibility of an element
    void explicitWaitVisibile(WebElement element, int seconds){
        Wait<WebDriver> wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
        wait.until(e->element.isDisplayed());
    }


    void handleTabsAndWindows(String starting){
        Set<String> allWindowHandles = driver.getWindowHandles();
        for(String w:allWindowHandles){
            if(w!=starting){
                driver.switchTo().window(w);
            }
        }
    }

    // iframes
    void switchToiFrame(String identifier){
        driver.switchTo().frame(identifier);
    }


    // Actions class

    void scrollToElem(WebElement element){
        Actions actions = new Actions(driver);
        actions.scrollToElement(element).perform();
    }

    void dragdrop(WebElement source, WebElement target){
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source,target).perform();
    }

}
