import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InputsTest extends BaseTest{
    @BeforeMethod
    public void navigate(){
            driver.get("http://the-internet.herokuapp.com/inputs");
        }
        @Test
        public void inputsTest() throws InterruptedException {
            WebElement testInput=driver.findElement(By.tagName("input"));
            testInput.sendKeys("fdvdfv");
            testInput.getText();
            Assert.assertEquals(testInput.getText(),testInput.getText(),"not clear");

            testInput.sendKeys("2");
            WebElement element=driver.findElement(By.cssSelector("[type=number]"));
           Assert.assertEquals(driver.findElement(By.cssSelector("[type=number]")),driver.findElement(By.cssSelector("[type=number]")),"no numbers");

           testInput.sendKeys(Keys.ARROW_UP);
            WebElement elementTwo=driver.findElement(By.cssSelector("[type=number]"));
            Assert.assertEquals(driver.findElement(By.cssSelector("[type=number]")),driver.findElement(By.cssSelector("[type=number]")),"no numbers");

            testInput.sendKeys(Keys.ARROW_DOWN);
            WebElement elementThree=driver.findElement(By.cssSelector("[type=number]"));
            Assert.assertEquals(driver.findElement(By.cssSelector("[type=number]")),driver.findElement(By.cssSelector("[type=number]")),"no numbers");

    }
}


