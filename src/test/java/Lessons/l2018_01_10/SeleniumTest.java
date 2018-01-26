package Lessons.l2018_01_10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.System.setProperty;

public class SeleniumTest {

    @Test
    public void testChrome1() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();

        driver.navigate().to("https://www.epam.com/");
        Assert.assertEquals(driver.getTitle(),"EPAM | Software Product Development Services");
        WebElement searchButton = driver.findElement(By.cssSelector(".header-search__button"));
        searchButton.click();

        WebElement menuButton = driver.findElement(By.cssSelector(".hamburger-menu__button"));
        Assert.assertTrue(menuButton.isDisplayed());
        Assert.assertEquals(menuButton.getText(), "MENU");

        menuButton.getAttribute("class");


        driver.close();
        driver.quit();
    }

    @Test
    public void testChrome2() {
        //setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.epam.com/");
        driver.close();
    }

//    @Test(dependsOnMethods = "test1")
//    public void dragAndDropTest() {
//        WebDriver driver = new FirefoxDriver();
//        driver.navigate().to("https://www.epam.com/");
//        driver.close();
//    }
}
