import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class InputsTest extends BaseTest{
    @BeforeMethod
    public void navigate(){
            driver.get("http://the-internet.herokuapp.com/inputs");
        }
        @Test
        public void inputsTest() throws InterruptedException {
            WebElement fieldInput=driver.findElement(By.tagName("input"));
            fieldInput.sendKeys("fdvdfv");
            Assert.assertEquals(fieldInput.getAttribute("value"),"","not clear");

            fieldInput.sendKeys("2");
            String firstResult=fieldInput.getAttribute("value");
            Assert.assertEquals(firstResult,"2","no numbers");

            fieldInput.sendKeys(Keys.ARROW_UP);
            String secondResult=fieldInput.getAttribute("value");
            Assert.assertEquals(secondResult,"3","no numbers");

            fieldInput.sendKeys(Keys.ARROW_DOWN);
            String thirdResult=fieldInput.getAttribute("value");
            Assert.assertEquals(thirdResult,"2","no numbers");
    }
}
