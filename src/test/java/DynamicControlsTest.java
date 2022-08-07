import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DynamicControlsTest extends BaseTest {
    @BeforeMethod
    public void navigate() {

        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
    }

    public boolean isElementPresent(By locator) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        boolean isPresent = !driver.findElements(locator).isEmpty();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return isPresent;
    }

    @Test
    public void dynamicControlsTest() {

        WebElement checkbox = driver.findElement(By.xpath("//div[@id='checkbox']"));
        Assert.assertTrue(checkbox.isDisplayed());
        WebElement checkboxBird = driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkboxBird.click();
        Assert.assertTrue(checkboxBird.isSelected());
        WebElement removeButton = driver.findElement(By.xpath("//button[text()='Remove']"));
        Assert.assertTrue(removeButton.isDisplayed());
        removeButton.click();

        WebElement itsGoneText = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(itsGoneText.isDisplayed());

        String text = driver.findElement(By.xpath("//p[@id='message']")).getText();
        Assert.assertEquals(text, "It's gone!", "text not here");

        Assert.assertFalse(isElementPresent(By.xpath("//input[@type='checkbox']")));


        WebElement input = driver.findElement(By.xpath("//input"));
        Assert.assertFalse(input.isEnabled(), "input enabled");
        WebElement enableButton = driver.findElement(By.xpath("//button[text()='Enable']"));
        Assert.assertTrue(enableButton.isDisplayed());
        enableButton.click();

        WebElement itEnabledText = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p#message")));
        Assert.assertTrue(itEnabledText.isDisplayed());

        String textTwo = driver.findElement(By.xpath("//p[@id='message']")).getText();
        Assert.assertEquals(textTwo, "It's enabled!", "text not here");
        Assert.assertTrue(input.isEnabled(), "input disabled");
    }
}
