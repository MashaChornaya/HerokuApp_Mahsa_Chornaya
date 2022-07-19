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
            WebElement testInput=driver.findElement(By.tagName("input"));
            testInput.sendKeys("fdvdfv");
            Assert.assertEquals(testInput.getText(),"","not clear");

            WebElement testInput2=driver.findElement(By.tagName("input"));
            testInput2.sendKeys("2");
            WebElement elementOne=driver.findElement(By.cssSelector("[type='number']"));
            String actText1=driver.findElement(By.cssSelector("[type='number']")).getText();
            Assert.assertEquals(actText1,"2","no numbers");

            WebElement testInput3=driver.findElement(By.tagName("input"));
            testInput.sendKeys(Keys.ARROW_UP);
            WebElement elementTwo=driver.findElement(By.cssSelector("[type='number']"));

            String actText2=driver.findElement(By.cssSelector("[type='number']")).getText();
            Assert.assertEquals(actText2,"3","no numbers");

            WebElement testInput4=driver.findElement(By.tagName("input"));
            testInput.sendKeys(Keys.ARROW_DOWN);
            WebElement elementThree=driver.findElement(By.cssSelector("[type='number']"));
            String actText3=driver.findElement(By.cssSelector("[type='number']")).getText();
            Assert.assertEquals(actText3,"2","no numbers");

    }
}
