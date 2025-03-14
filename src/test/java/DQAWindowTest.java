import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DQAWindowTest extends Base{
    DemoQAWindow dqa;

    @BeforeMethod
    void setUp(){
        getSite1("https://demoqa.com/browser-windows");
        dqa= PageFactory.initElements(driver,DemoQAWindow.class);
    }

    @Test
    void newWindoW(){
        dqa.newWindowM();
    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }

}
