package homework.homework_2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class BenefitsTextTestDataProvider_vol2 {
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
                {"To include good practices and ideas from successful EPAM projec"},
                {"To be flexible and customizable"},
                {"To be multiplatform"},
                {"Already have good base (about 20 internal and some external projects)," +
                        " wish to get more\u2026"}
        };
    }

    @Test(dataProvider = "textBelowPics")
    public void textBelowPicTest(String content) throws Exception {
        List<String> benefits = driver
                .findElements(By.cssSelector(".benefit-txt")).stream()
                .map(WebElement::getText)
                .map(s -> s.replaceAll("\n", " ")).collect(Collectors.toList());

        Assert.assertTrue(benefits.contains(content));
    }

}
