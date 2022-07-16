import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;




public class DynamicControlsTest extends BaseTest {
    @BeforeMethod
    public void navigate() {

        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
    }

    @Test
    public void dynamicControlsTest()  {

        WebElement checkbox = driver.findElement(By.xpath("//div[@id='checkbox']"));
        Assert.assertTrue(checkbox.isDisplayed());
        WebElement checkboxBird = driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkboxBird.click();
        Assert.assertTrue(checkboxBird.isSelected());
        WebElement removeButton = driver.findElement(By.xpath("//button[text()='Remove']"));
        Assert.assertTrue(removeButton.isDisplayed());
        removeButton.click();
        String  text=driver.findElement(By.xpath("//p[@id='message']")).getText();

        Assert.assertTrue(isElementPresent(By.xpath("//p[@id='message']")),"Text its gone not here");

        Assert.assertFalse(isElementPresent(By.xpath("//input[@type='checkbox']")),"Checkbox is here");

        WebElement input=driver.findElement(By.xpath("//input"));
        Assert.assertFalse(input.isEnabled(),"input enabled");
        WebElement enableButton= driver.findElement(By.xpath("//button[text()='Enable']"));
        Assert.assertTrue(enableButton.isDisplayed());
        enableButton.click();
        String textTwo=driver.findElement(By.xpath("//p[@id='message']")).getText();
        Assert.assertTrue(isElementPresent(By.xpath("//p[@id='message']")),"Text its enabled not here");

        Assert.assertTrue(input.isEnabled(),"input disabled");
    }
}
