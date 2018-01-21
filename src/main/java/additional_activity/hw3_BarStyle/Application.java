package additional_activity.hw3_BarStyle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Application {
    private WebDriver driver;

    private IndexPage indexPage;


    public Application() {
        driver = new ChromeDriver();
        indexPage = new IndexPage(driver);
    }


    public void quit() {
        driver.quit();
    }

    public void performLogin() {
        indexPage.open();
//        homePage.userLoginMenu.click();
//        wait.until(ExpectedConditions.titleIs(innerDataProvider.TITLE));
        driver.findElement(By.cssSelector(".uui-profile-menu")).click();
        driver.findElement(By.id("Login")).sendKeys("epam");
        driver.findElement(By.id("Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".uui-button")).click();
    }

    public void performLogout() {
        driver.findElement(By.cssSelector(".fa fa-sign-out")).click();
    }

}
