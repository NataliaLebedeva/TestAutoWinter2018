package homework.homework_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void preconditions() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void postconditions() {
        //10. Close Browser
        driver.close();
    }
}
