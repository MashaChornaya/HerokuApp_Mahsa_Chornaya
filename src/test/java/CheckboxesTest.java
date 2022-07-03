import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

      firstCheckBox.isSelected();
      firstCheckBox.click();
      firstCheckBox.isSelected();

      WebElement secondCheckBox=driver.findElement(By.cssSelector("[type=checkbox]"));
      secondCheckBox.isSelected();
      secondCheckBox.click();
      secondCheckBox.isSelected();
    }
}
