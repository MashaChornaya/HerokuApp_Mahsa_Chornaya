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
        String text=driver.findElement(By.tagName("div")).getText();
        String actualText=driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(actualText,"Sometimes you'll see a typo, other times you won't.","typo in text");
    }
}
