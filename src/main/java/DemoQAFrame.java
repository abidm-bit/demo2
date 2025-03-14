import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DemoQAFrame extends Base{

//

    @FindBy(css="#sampleHeading")
    WebElement header1;




    void switchTofirstiframe(){
        switchToiFrame("frame1");
        Assert.assertEquals(header1.getText(),"This is a sample page");
    }


}
