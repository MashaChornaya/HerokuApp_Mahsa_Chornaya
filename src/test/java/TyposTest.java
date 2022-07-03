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

       WebElement text=driver.findElement(By.tagName("p"));

       String actualText=driver.findElement(By.tagName("p")).getText();

       Assert.assertEquals(actualText,"This example demonstrates a typo being introduced. It does it randomly on each page load.","typo in text");
    }
}
