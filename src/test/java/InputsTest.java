import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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
            testInput.sendKeys("2");
            testInput.sendKeys(Keys.ARROW_UP);
            testInput.sendKeys(Keys.ARROW_DOWN);
    }
}


