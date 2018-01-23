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

    private WebDriver driver;
    private IndexPageObject indexPage;

    @BeforeTest
    public void beforeTest() {
        //create a driver instance
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.manage().window().maximize();
        //create an object of page
        indexPage = PageFactory.initElements(driver, IndexPageObject.class);
    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }

    @Test
    public void indexPageTest() {
        //2. Open index page
        //3. Assert Browser title
        indexPage.open();

        //4. Perform login
        indexPage.login(PITER_CHAILOVSKII);
        //5. Assert User name in the left-top side of screen that user is login in
        indexPage.checkUserInfo(PITER_CHAILOVSKII);
        //6. Assert that there are 4 images on the Home Page and they are displayed
        indexPage.checkBenefitIcons();
        //7. Assert that there are 4 texts on the Home Page and check them by getting texts
        indexPage.checkBenefitsTexts();
        //8. Assert that there are the main header and the text below it on the Home Page
        indexPage.checkMainText();
    }
}
