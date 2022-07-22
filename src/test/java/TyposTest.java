import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class TyposTest extends BaseTest{
    @BeforeMethod
    public void navigate(){
        driver.get("http://the-internet.herokuapp.com/typos");
    }
    @Test
    public void typosTest() throws InterruptedException {
       List <WebElement> text = driver.findElements(By.tagName("p"));
       Assert.assertEquals(text.get(1).getText(),"Sometimes you'll see a typo, other times you won't.","typo in text");
    }
}

