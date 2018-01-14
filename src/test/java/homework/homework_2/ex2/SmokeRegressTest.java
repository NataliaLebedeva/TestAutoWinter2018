package homework.homework_2.ex2;

import homework.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class SmokeRegressTest extends TestBase {

    private static final String USERNAME = "Piter Chailovskii";
    private static final String MAIN_TITLE = "EPAM FRAMEWORK WISHES\u2026";
    private static final String MAIN_TEXT = "LOREM IPSUM DOLOR SIT AMET, " +
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

    @Test(dataProvider = "data", groups = {"smoke", "regression"})
    public void textCompareTest(String title, String content) {
        String commonLocator = "//span[contains(@class,'%s')]/../../span";
        wait.until(ExpectedConditions.textToBe(By.xpath(String.format(commonLocator, title)), content));
    }

    @Test(groups = {"smoke", "regression"})
    public void loginTest() {
        driver.findElement(By.cssSelector(".uui-profile-menu")).click();
        driver.findElement(By.id("Login")).sendKeys("epam");
        driver.findElement(By.id("Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".uui-button")).click();
        WebElement profileInfo = driver.findElement(By.cssSelector(".profile-photo span"));
        Assert.assertTrue(USERNAME.equalsIgnoreCase(profileInfo.getText()));
    }

    @Test(groups = {"smoke", "regression"})
    public void compareMainTest() {
        List<WebElement> images = driver.findElements(By.cssSelector(".benefit-icon span"));
        Assert.assertEquals(images.size(), 4);
        for (WebElement img : images) {
            Assert.assertTrue(img.isDisplayed());
        }

        WebElement actualMainTitle = driver.findElement(By.cssSelector(".main-txt"));
        Assert.assertEquals(MAIN_TEXT, actualMainTitle.getText());
        WebElement actualMainTxt = driver.findElement(By.cssSelector(".main-title"));
        Assert.assertEquals(MAIN_TITLE, actualMainTxt.getText());
    }

}
