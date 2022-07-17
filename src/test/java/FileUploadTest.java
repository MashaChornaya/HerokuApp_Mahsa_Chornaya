import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest{
    @BeforeMethod
    public void navigate() {

        driver.get("http://the-internet.herokuapp.com/upload");
    }
    @Test
    public void fileUploadTest() {

        String filePath="C:/Program Files/Java/Sharelane/HerokuApp_Mahsa_Chornaya/src/resourses/Screenshot_1.png";
        WebElement chooseInput=driver.findElement(By.cssSelector("#file-upload"));
        Assert.assertTrue(chooseInput.isDisplayed());
        chooseInput.sendKeys(filePath);

        isElementPresent(By.xpath("//span[@data-dz-name and text()]"));

        WebElement uploadButton=driver.findElement(By.cssSelector(".button"));
        Assert.assertTrue(uploadButton.isEnabled());
        uploadButton.click();

       WebElement uploadedText=driver.findElement(By.cssSelector("#uploaded-files"));
       Assert.assertEquals(uploadedText.getText(),"Screenshot_1.png");

}}
