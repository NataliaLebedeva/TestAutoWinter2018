package homework.homework_2.ex2;

import homework.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static homework.DriverFactory.GetDriver;

public class SmokeTest extends TestBase {

    private static final String MAIN_TITLE = "EPAM FRAMEWORK WISHES\u2026";
    private static final String MAIN_TEXT = "LOREM IPSUM DOLOR SIT AMET, " +
            "CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA " +
            "ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP " +
            "EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE " +
            "CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
    private WebDriverWait wait;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        GetDriver().get("https://jdi-framework.github.io/tests/index.htm");
        wait = new WebDriverWait(GetDriver(), 10);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        //10. Close Browser
        GetDriver().close();
    }

    @Test(groups = "smoke")
    public void compareMainTest() {
        List<WebElement> images = GetDriver().findElements(By.cssSelector(".benefit-icon span"));
        Assert.assertEquals(images.size(), 4);
        for (WebElement img : images) {
            Assert.assertTrue(img.isDisplayed());
        }

        WebElement actualMainTitle = GetDriver().findElement(By.cssSelector(".main-txt"));
        Assert.assertEquals(MAIN_TEXT, actualMainTitle.getText());
        WebElement actualMainTxt = GetDriver().findElement(By.cssSelector(".main-title"));
        Assert.assertEquals(MAIN_TITLE, actualMainTxt.getText());
    }

    @Test(groups = "smoke")
    public void negativeLoginTest() {
        GetDriver().findElement(By.cssSelector(".uui-profile-menu")).click();
        GetDriver().findElement(By.id("Login")).sendKeys("epam");
        GetDriver().findElement(By.id("Password")).sendKeys("0000");
        GetDriver().findElement(By.cssSelector(".uui-button")).click();
        WebElement profileInfo = GetDriver().findElement(By.cssSelector(".login-txt"));
        Assert.assertEquals(profileInfo.getText(), "* Login Faild");
    }

}
