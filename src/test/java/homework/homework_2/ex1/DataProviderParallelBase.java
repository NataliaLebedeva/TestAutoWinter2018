package homework.homework_2.ex1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class DataProviderParallelBase {
    ThreadLocal<WebDriver> webDriverLocal = new ThreadLocal<>();

    @BeforeMethod
    public void beforeMethod() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        webDriverLocal.set(driver);
    }

    @AfterMethod
    public void afterMethod() {
        webDriverLocal.get().quit();
    }
}
