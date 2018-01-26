package homework.homework_1;

import homework.DriverFactory;
import homework.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static homework.DriverFactory.*;
import static org.testng.Assert.*;

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
        WebDriverWait wait = new WebDriverWait(GetDriver(), 10);
        wait.until(ExpectedConditions.titleIs(TITLE));

        //4. Perform login
        GetDriver().findElement(By.cssSelector(".uui-profile-menu")).click();
        GetDriver().findElement(By.id("Login")).sendKeys("epam");
        GetDriver().findElement(By.id("Password")).sendKeys("1234");
        GetDriver().findElement(By.cssSelector(".uui-button")).click();

        //5. Assert User name in the left-top side of screen that user is loggined
        WebElement profileInfo = GetDriver().findElement(By.cssSelector(".profile-photo span"));
        assertTrue(USERNAME.equalsIgnoreCase(profileInfo.getText()));

        //6. Assert Browser title
        wait.until(ExpectedConditions.titleIs(TITLE));

        //7. Assert that there are 4 images on the Home Page and they are displayed
        List<WebElement> images = GetDriver().findElements(By.cssSelector(".benefit-icon span"));
        assertEquals(images.size(), 4);
        for (WebElement img : images) {
            assertTrue(img.isDisplayed());
        }

        //8. Assert that there are 4 texts on the Home Page and check them by getting texts
        List<WebElement> textBelowImg = GetDriver().findElements(By.cssSelector(".benefit-txt"));
        assertEquals(textBelowImg.size(), 4);
        textBelowImg.forEach(element -> assertTrue(texts.contains(element.getText().replaceAll("\n", " "))));

        //9. Assert that there are the main header and the text below it on the Home Page
        assertEquals(MAIN_TEXT, GetDriver().findElement(By.cssSelector(".main-txt")).getText());
        assertEquals(MAIN_TITLE, GetDriver().findElement(By.cssSelector(".main-title")).getText());
    }
}
