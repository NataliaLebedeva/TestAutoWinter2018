package additional_activity.vol2;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import additional_activity.vol2.entities.User;
import additional_activity.vol2.pageObject.JDITestSite;

import static java.util.concurrent.TimeUnit.SECONDS;

public class JDITests {

    ChromeDriver driver;

    @BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void loginTest() throws InterruptedException {
        JDITestSite.init(driver);
        JDITestSite.open();

        JDITestSite.commonPage.login(new User("epam", "1234"));

        Assert.assertEquals(JDITestSite.commonPage.getProfileInfo(), "PITER CHAILOVSKII");
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

}
