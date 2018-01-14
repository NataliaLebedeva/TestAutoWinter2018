package homework.homework_2.ex3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://www.epam.com/");
    }

    @Test
    public void firstTest() {

    }

    @AfterMethod
    public void afterMethod() {

    }

    @AfterClass
    public void afterClass() {

    }

    @AfterTest
    public void afterTest() {

    }

    @AfterSuite
    public void afterSuite() {

    }
}

