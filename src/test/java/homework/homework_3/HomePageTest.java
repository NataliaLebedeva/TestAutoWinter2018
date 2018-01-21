package homework.homework_3;

import homework.homework_3.pageObjects.IndexPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static homework.homework_3.entities.User.PITER_CHAILOVSKII;
import static java.util.concurrent.TimeUnit.SECONDS;

public class HomePageTest {

    WebDriver driver;
    private IndexPageObject indexPage;

    @BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.manage().window().maximize();
        indexPage = PageFactory.initElements(driver, IndexPageObject.class);
    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }

    @Test
    public void indexPageTest() {
        indexPage.open();
        indexPage.login(PITER_CHAILOVSKII);
        indexPage.checkUserInfo(PITER_CHAILOVSKII);
        indexPage.checkBenefitsTexts();
        indexPage.checkMainText();
    }
}
