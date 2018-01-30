package homework.homework_2.ex3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static java.lang.System.setProperty;

public class AnnotationsTest {
    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }


    @BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
    }


    @BeforeClass
    public void beforeClass() {
        driver.get("http://epam.com");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println(driver.getTitle());
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println(System.currentTimeMillis());
    }

    @AfterClass
    public void afterClass() {
        System.out.println("afterClass");
    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }

    @AfterSuite
    public void afterSuite() {
        if (!driver.toString().contains("null")) {
            driver.quit();
        }
    }

    ////////////////////////////////

    @Test
    public void firstTest() {
        Assert.assertTrue(true);
    }
}

