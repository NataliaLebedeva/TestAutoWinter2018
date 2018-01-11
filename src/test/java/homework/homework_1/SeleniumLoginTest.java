package homework.homework_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumLoginTest {
    static final String TITLE = "Index page";
    static final String USERNAME = "Piter Chailovskii";
    static final String PRACTICES = "To include good practices and ideas from successful EPAM projec";
    static final String CUSTOM = "To be flexible and customizable ";
    static final String MULTI = "To be multiplatform ";
    static final String BASE = "Already have good base (about 20 internal and some external projects), wish to get more…";
    private WebDriver  driver;

    //1.Create a new test, specify test name in accordance with checking functionality
    @BeforeMethod
    public void preconditions(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2. Open test site by URL
        driver.navigate().to("https://jdi-framework.github.io/tests");
    }

    @Test
    public void loginTest() {

        //3. Assert Browser title
        Assert.assertEquals(driver.getTitle(), "Index Page");

        //4. Perform login
        driver.findElement(By.cssSelector(".uui-profile-menu")).click();
        driver.findElement(By.id("Login")).sendKeys("epam");
        driver.findElement(By.id("Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".uui-button")).click();

        //5. Assert User name in the left-top side of screen that user is loggined
        WebElement profileInfo = driver.findElement(By.cssSelector(".profile-photo span"));
        Assert.assertTrue(profileInfo.isDisplayed());
        String name = profileInfo.getText();
        Assert.assertTrue("Piter Chailovskii".equalsIgnoreCase(name));

        //6. Assert Browser title
        Assert.assertEquals(driver.getTitle(), "Index Page");
        //7. Assert that there are 4 images on the Home Page and they are displayed
        //8. Assert that there are 4 texts on the Home Page and check them by getting texts
        //9. Assert that there are the main header and the text below it on the Home Page


    }

    @AfterMethod
    public void closeBrowser() {
        //10. Close Browser
        driver.close();
        driver.quit();
    }


}
