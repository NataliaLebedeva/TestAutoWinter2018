package homework.homework_1;

import homework.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SeleniumLoginTest extends TestBase {
    private final String TITLE = "Index Page";
    private final String USERNAME = "Piter Chailovskii";
    private final String MAIN_TITLE = "EPAM FRAMEWORK WISHES\u2026";
    private final String MAIN_TEXT = "LOREM IPSUM DOLOR SIT AMET, " +
            "CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA " +
            "ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP " +
            "EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE " +
            "CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";

    private final List<String> texts = new ArrayList<String>(){{
        add("To include good practices and ideas from successful EPAM projec");
        add("To be flexible and customizable");
        add("To be multiplatform");
        add("Already have good base (about 20 internal and some external projects), wish to get more\u2026");
    }};

    @Test
    public void loginTest() {

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
        for (WebElement img : images) {
            Assert.assertTrue(img.isDisplayed());
        }

        //8. Assert that there are 4 texts on the Home Page and check them by getting texts
        List<WebElement> textBelowImg = driver.findElements(By.cssSelector(".benefit-txt"));
        Assert.assertEquals(textBelowImg.size(), 4);
        for(int i = 0; i < texts.size(); i++) {
            Assert.assertEquals(textBelowImg.get(i).getText().replaceAll("\n", " "), texts.get(i));
//            assertContains(texts.contains(element.getText()));
        }

        //9. Assert that there are the main header and the text below it on the Home Page
        Assert.assertEquals(MAIN_TEXT, driver.findElement(By.cssSelector(".main-txt")).getText());
        Assert.assertEquals(MAIN_TITLE, driver.findElement(By.cssSelector(".main-title")).getText());


    }
}
