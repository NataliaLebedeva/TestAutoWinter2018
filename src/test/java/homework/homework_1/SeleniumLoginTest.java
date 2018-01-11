package homework.homework_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SeleniumLoginTest {
    private static final String TITLE = "Index page";
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
            "wish to get more…";
    private WebDriver driver;

    //1.Create a new test, specify test name in accordance with checking functionality
    @BeforeMethod
    public void preconditions() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2. Open test site by URL
        driver.navigate().to("https://jdi-framework.github.io/tests");
    }

    @Test
    public void loginTest() {

        //3. Assert Browser title
        Assert.assertTrue(TITLE.equalsIgnoreCase(driver.getTitle()));

        //4. Perform login
        driver.findElement(By.cssSelector(".uui-profile-menu")).click();
        driver.findElement(By.id("Login")).sendKeys("epam");
        driver.findElement(By.id("Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".uui-button")).click();

        //5. Assert User name in the left-top side of screen that user is loggined
        WebElement profileInfo = driver.findElement(By.cssSelector(".profile-photo span"));
        Assert.assertTrue(profileInfo.isDisplayed());
        String name = profileInfo.getText();
        Assert.assertTrue(USERNAME.equalsIgnoreCase(name));

        //6. Assert Browser title
        Assert.assertTrue(TITLE.equalsIgnoreCase(driver.getTitle()));

        //7. Assert that there are 4 images on the Home Page and they are displayed
        List<WebElement> images = driver.findElements(By.cssSelector(".benefit-icon span"));
        Assert.assertEquals(images.size(), 4);
        for (WebElement img: images) {
            Assert.assertTrue(img.isDisplayed());
        }

        //8. Assert that there are 4 texts on the Home Page and check them by getting texts
        List<WebElement> textBelowImg = driver.findElements(By.cssSelector(".benefit-txt"));
        Assert.assertEquals(textBelowImg.size(), 4);

        Assert.assertEquals(PRACTICES, driver.findElement(By.xpath("//span[contains(@class,'practise')]/../../span")).getText());
        Assert.assertEquals(CUSTOM, driver.findElement(By.xpath("//span[contains(@class,'custom')]/../../span")).getText());
        Assert.assertEquals(MULTI, driver.findElement(By.xpath("//span[contains(@class,'multi')]/../../span")).getText());
        Assert.assertEquals(BASE, driver.findElement(By.xpath("//span[contains(@class,'base')]/../../span")).getText());
        
        //9. Assert that there are the main header and the text below it on the Home Page


    }

    @AfterMethod
    public void postconditions() {
        //10. Close Browser
        driver.close();
        driver.quit();
    }


}
