import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownTest extends BaseTest {

    @BeforeMethod
    public void navigate() {

        driver.get("http://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void selectDropDownTest() throws InterruptedException {
       WebElement dropdownElement= driver.findElement(By.id("dropdown"));
       Select select=new Select(dropdownElement);
       List<WebElement> options=select.getOptions();
       List<String> expectedOptions= new ArrayList<>();

       expectedOptions.add("Please select an option");
       expectedOptions.add("Option 1");
       expectedOptions.add("Option 2");
       List <String> actualOptions = options.stream().map(option -> option.getText()).toList();
       Assert.assertEquals(expectedOptions, actualOptions);
       select.selectByValue("1");
       select.selectByIndex(1);
       Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 1","first element not selected");
       select.selectByVisibleText("Option 2");
       select.getFirstSelectedOption().getText();
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 2","second element not selected");

    }
}
