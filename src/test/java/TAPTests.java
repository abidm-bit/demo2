import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TAPTests extends Base{
    TestAutomationPractice tap;

@BeforeMethod
    void setUp(){
    getSite1("https://testautomationpractice.blogspot.com/");
    tap = PageFactory.initElements(driver,TestAutomationPractice.class);
}


@Test(enabled = false)
void newTabMethod(){
    tap.searchBoxTab("Catcher in the Rye");
}


@Test
    void draganddrop(){
    tap.dnd();
}


@AfterMethod
    void tearDown(){
    driver.quit();
}




}
