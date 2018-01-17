package homework.homework_2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class TextDPTest {
    private WebDriver driver;

    @BeforeTest
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://jdi-framework.github.io/tests/index.htm");
        new WebDriverWait(driver, 10);
    }

    @AfterTest
    public void afterClass() {
        driver.close();
    }

    @DataProvider(parallel = true)
    public Object[][] textBelowPics() {
        return new Object[][]{
                {"practise", "To include good practices and ideas from successful EPAM projec"},
                {"custom", "To be flexible and customizable"},
                {"multi", "To be multiplatform"},
                {"base", "Already have good base (about 20 internal and some external projects)," +
                        " wish to get more\u2026"}
        };
    }

    @Test(dataProvider = "textBelowPics")
    public void textBelowPicTest(String locator, String content) {
        assertEquals(driver.findElement(By.xpath(String.format("//span[contains(@class,'%s')]/../../span",
                locator))).getText().replaceAll("\n", " "), content);
    }

}
