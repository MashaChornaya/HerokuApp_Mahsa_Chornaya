import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CheckboxesTest extends BaseTest {
    @BeforeMethod
    public void navigate() {

        driver.get("http://the-internet.herokuapp.com/checkboxes");
    }
    @Test
    public void testCheckboxes(){
        WebElement firstCheckBox=driver.findElement(By.cssSelector("[type=checkbox]"));

      firstCheckBox.isEnabled();
        Assert.assertTrue(firstCheckBox.isEnabled(),"first checkbox is selected");
      firstCheckBox.click();
      firstCheckBox.isSelected();
        Assert.assertTrue(firstCheckBox.isSelected(),"first checkbox is not selected");

      WebElement secondCheckBox=driver.findElement(By.cssSelector("[type=checkbox]"));
      secondCheckBox.isSelected();
        Assert.assertTrue(secondCheckBox.isSelected(),"Second checkbox is not selected");
        secondCheckBox.click();
      secondCheckBox.isEnabled();
        Assert.assertTrue(secondCheckBox.isEnabled(),"Second checkbox is  selected");

    }
}
