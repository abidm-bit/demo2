import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DQAFrameTest extends Base{
    DemoQAFrame dqaframe;


    @BeforeMethod
    void setUp(){
        getSite1("https://demoqa.com/frames");
        dqaframe = PageFactory.initElements(driver,DemoQAFrame.class);
    }

    @Test
    void interactWFirstFrame(){
        dqaframe.switchTofirstiframe();
    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }

}
