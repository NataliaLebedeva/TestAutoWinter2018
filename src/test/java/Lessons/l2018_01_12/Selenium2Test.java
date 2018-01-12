package Lessons.l2018_01_12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Selenium2Test {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.ru/");
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void chromeTest() {
        driver.findElement(By.id(".lst-ib")).sendKeys("java search");

    }
}
