import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {
        protected WebDriver driver;

        @BeforeClass
        public void setUp() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
    public boolean isElementPresent(By locator) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        boolean isPresent = !driver.findElements(locator).isEmpty();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return isPresent;
    }
        @AfterClass
        public void tearDown() {driver.quit();}
    }

