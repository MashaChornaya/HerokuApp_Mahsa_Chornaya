import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddRemoveElementsTests extends BaseTest{
    @BeforeMethod
    public void navigate() {

        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    }
    @Test
    public void testAddRemove() {
        WebElement addButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
        deleteButtons.isEmpty();
        Assert.assertTrue(deleteButtons.isEmpty(),"Not empty");
        addButton.click();
        addButton.click();
        deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
        deleteButtons.size();
        deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
        deleteButtons.get(0).click();
        deleteButtons.size();

        Assert.assertEquals(deleteButtons.size(),deleteButtons.size(),"wrong number of buttons");
    }
}

