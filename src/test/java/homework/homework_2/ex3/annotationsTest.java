package homework.homework_2.ex3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import static java.lang.System.setProperty;

public class annotationsTest {
    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @AfterSuite
    public void afterSuite() {
        if (driver.toString().contains("null")) {
            driver.quit();
        }
    }

    @BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }

    @BeforeClass
    public void beforeClass() {
        driver.get("https://www.epam.com/");
    }

    @AfterClass
    public void afterClass() {
        System.out.println(System.currentTimeMillis());
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println(driver.getTitle());
    }

    @AfterMethod
    public void afterMethod() {
        new WebDriverWait(driver, 2);
    }

    @Test
    public void firstTest() {
        Assert.assertEquals(driver.findElement(By.cssSelector(".hamburger-menu__button")).getText(), "MENU");
    }
}

