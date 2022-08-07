import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest {

    @BeforeMethod
    public void navigate() {

        driver.get("http://the-internet.herokuapp.com/context_menu");
    }
    @Test
    public void contextMenuTest()  {
    Actions firstAction= new Actions(driver);
    WebElement element= driver.findElement(By.cssSelector("#hot-spot"));
    Assert.assertTrue(element.isDisplayed());
    firstAction.contextClick(element).build().perform();


    Alert firstAlert = driver.switchTo().alert();
    String alertText = firstAlert.getText();
    Assert.assertFalse(alertText.isEmpty());
    firstAlert.accept();
    driver.switchTo().defaultContent();
    }
}



