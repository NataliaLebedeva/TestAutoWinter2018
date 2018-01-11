package homework.homework_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumLoginTest {
    //1.Create a new test, specify test name in accordance with checking functionality
    @Test
    public void loginTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2. Open test site by URL
        driver.navigate().to("https://jdi-framework.github.io/tests");
        //3. Assert Browser title
        Assert.assertEquals(driver.getTitle(), "Index Page");
        //4. Perform login
        //5. Assert User name in the left-top side of screen that user is loggined
        //6. Assert Browser title
        Assert.assertEquals(driver.getTitle(), "Index Page");
        //7. Assert that there are 4 images on the Home Page and they are displayed
        //8. Assert that there are 4 texts on the Home Page and check them by getting texts
        //9. Assert that there are the main header and the text below it on the Home Page
        //10. Close Browser
        driver.close();
        driver.quit();

    }


}
