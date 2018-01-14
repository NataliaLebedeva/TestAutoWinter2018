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
        setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Driver/chromedriver.exe");
    }

    @BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
    }

    @BeforeClass
    public void beforeClass() {
        driver.get("https://www.epam.com/");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println(driver.getTitle());
    }

    @Test
    public void firstTest() {
        Assert.assertEquals(driver.findElement(By.cssSelector(".hamburger-menu__button")).getText(), "MENU");
    }

    @AfterMethod
    public void afterMethod() {
        new WebDriverWait(driver, 2);
    }

    @AfterClass
    public void afterClass() {
        System.out.println(System.currentTimeMillis());
    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }

    @AfterSuite
    public void afterSuite() {
        if (driver.toString().contains("null")) {
            driver.quit();
        }
    }
}

