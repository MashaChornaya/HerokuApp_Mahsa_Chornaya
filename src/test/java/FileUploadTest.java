import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest {
    @BeforeMethod
    public void navigate() {

        driver.get("http://the-internet.herokuapp.com/upload");
    }

    @Test
    public void fileUploadTest() {

        WebElement fileUploadInput = driver.findElement(By.cssSelector("#file-upload"));
        Assert.assertTrue(fileUploadInput.isDisplayed());
        fileUploadInput.sendKeys(System.getProperty("user.dir") + "/src/resourses/Screenshot_1.png");

        WebElement uploadButton = driver.findElement(By.cssSelector(".button"));
        Assert.assertTrue(uploadButton.isEnabled());
        uploadButton.click();

        WebElement uploadFile = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='content']/div/h3")));
        Assert.assertTrue(uploadFile.isDisplayed());

        WebElement uploadedText = driver.findElement(By.cssSelector("#uploaded-files"));
        Assert.assertEquals(uploadedText.getText(), "Screenshot_1.png");

    }
}
