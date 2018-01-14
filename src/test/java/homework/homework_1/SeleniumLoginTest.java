package homework.homework_1;

import homework.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SeleniumLoginTest extends TestBase {
    private static final String TITLE = "Index Page";
    private static final String USERNAME = "Piter Chailovskii";
    private static final String PRACTICES = "To include good practices\n" +
            "and ideas from successful\n" +
            "EPAM projec";
    private static final String CUSTOM = "To be flexible and\n" +
            "customizable";
    private static final String MULTI = "To be multiplatform";
    private static final String BASE = "Already have good base\n" +
            "(about 20 internal and\n" +
            "some external projects),\n" +
            "wish to get more\u2026";
    private static final String MAIN_TITLE = "EPAM FRAMEWORK WISHES\u2026";
    private static final String MAIN_TEXT = "LOREM IPSUM DOLOR SIT AMET, " +
            "CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA " +
            "ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP " +
            "EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE " +
            "CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";

    @Test
    public void loginTest() {
        //2. Open test site by URL
        driver.navigate().to("https://jdi-framework.github.io/tests");
        //3. Assert Browser title
        wait.until(ExpectedConditions.titleIs(TITLE));

        //4. Perform login
        driver.findElement(By.cssSelector(".uui-profile-menu")).click();
        driver.findElement(By.id("Login")).sendKeys("epam");
        driver.findElement(By.id("Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".uui-button")).click();

        //5. Assert User name in the left-top side of screen that user is loggined
        WebElement profileInfo = driver.findElement(By.cssSelector(".profile-photo span"));
        Assert.assertTrue(USERNAME.equalsIgnoreCase(profileInfo.getText()));

        //6. Assert Browser title
        wait.until(ExpectedConditions.titleIs(TITLE));

        //7. Assert that there are 4 images on the Home Page and they are displayed
        List<WebElement> images = driver.findElements(By.cssSelector(".benefit-icon span"));
        Assert.assertEquals(images.size(), 4);
        for (WebElement img: images) {
            Assert.assertTrue(img.isDisplayed());
        }

        //8. Assert that there are 4 texts on the Home Page and check them by getting texts
        List<WebElement> textBelowImg = driver.findElements(By.cssSelector(".benefit-txt"));
        Assert.assertEquals(textBelowImg.size(), 4);

        String commonLocator = "//span[contains(@class,'%s')]/../../span";
        softAssert.assertEquals(PRACTICES,  driver.findElement(By.xpath(String.format(commonLocator,"practise"))).getText());
        softAssert.assertEquals(CUSTOM,     driver.findElement(By.xpath(String.format(commonLocator,"custom"))).getText());
        softAssert.assertEquals(MULTI,      driver.findElement(By.xpath(String.format(commonLocator,"multi"))).getText());
        softAssert.assertEquals(BASE,       driver.findElement(By.xpath(String.format(commonLocator,"base"))).getText());

        //9. Assert that there are the main header and the text below it on the Home Page
        WebElement actualMainTitle = driver.findElement(By.cssSelector(".main-txt"));
        Assert.assertEquals(MAIN_TEXT, actualMainTitle.getText());
        WebElement actualMainTxt = driver.findElement(By.cssSelector(".main-title"));
        Assert.assertEquals(MAIN_TITLE,actualMainTxt .getText());

        softAssert.assertAll();
    }
}
