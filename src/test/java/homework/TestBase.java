package homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected SoftAssert softAssert;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        softAssert = new SoftAssert();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        //10. Close Browser
        driver.close();
    }

}
