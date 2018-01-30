package homework.homework_2.ex2;

import homework.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class SmokeRegressTest extends SmokeAndRegressionPresets {

    private final String USERNAME = "Piter Chailovskii";
    private final String MAIN_TITLE = "EPAM FRAMEWORK WISHES\u2026";
    private final String MAIN_TEXT = "LOREM IPSUM DOLOR SIT AMET, " +
            "CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA " +
            "ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP " +
            "EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE " +
            "CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {"practise", "To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM projec"},
                {"custom", "To be flexible and\n" +
                        "customizable"},
                {"multi", "To be multiplatform"},
                {"base", "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more\u2026"},
        };
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        driver = DriverFactory.generateNewDriver("chrome");
        wait = new WebDriverWait(driver, 10);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.close();
    }

    @Test(dataProvider = "data", groups = "regression")
    public void firstTest(String title, String content) {
        String commonLocator = "//span[contains(@class,'%s')]/../../span";
        driver.get("https://jdi-framework.github.io/tests/index.htm");
        wait.until(ExpectedConditions.textToBe(By.xpath(String.format(commonLocator, title)), content));
    }

    @Test(groups = "regression")
    public void secondTest() {
        driver.get("https://jdi-framework.github.io/tests/index.htm");
        driver.findElement(By.cssSelector(".uui-profile-menu")).click();
        driver.findElement(By.id("Login")).sendKeys("epam");
        driver.findElement(By.id("Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".uui-button")).click();
        WebElement profileInfo = driver.findElement(By.cssSelector(".profile-photo span"));
        Assert.assertTrue(USERNAME.equalsIgnoreCase(profileInfo.getText()));
        driver.findElement(By.className("fa-sign-out")).click();
    }

    @Test(groups = "smoke")
    public void thirdTest() {
        driver.get("https://jdi-framework.github.io/tests/index.htm");
        List<WebElement> images = driver.findElements(By.cssSelector(".benefit-icon span"));
        Assert.assertEquals(images.size(), 4);
        for (WebElement img : images) {
            Assert.assertTrue(img.isDisplayed());
        }
    }

    @Test(groups = "smoke")
    public void fourthTest() {
        driver.get("https://jdi-framework.github.io/tests/index.htm");
        WebElement actualMainTitle = driver.findElement(By.cssSelector(".main-txt"));
        Assert.assertEquals(MAIN_TEXT, actualMainTitle.getText());
        WebElement actualMainTxt = driver.findElement(By.cssSelector(".main-title"));
        Assert.assertEquals(MAIN_TITLE, actualMainTxt.getText());
    }

}
