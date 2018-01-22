package homework.homework_4;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.open;
import static homework.homework_4.JDISite.init;
import static homework.homework_4.JDISite.loginForm;
import static homework.homework_4.entities.User.PITER_CHAILOVSKII;

public class SelenideBase {

    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;

        Configuration.timeout = 6000;
        Configuration.pollingInterval = 200;
        Configuration.collectionsPollingInterval = 300;

        init();
        //open site by URL
        open("https://jdi-framework.github.io/tests/index.htm");
    }

    @AfterSuite
    public void afterSuite() {
        //close driver after non-parallel test methods
        WebDriverRunner.closeWebDriver();
    }

    @BeforeMethod
    public void beforeMethod() {
        //perform login before every method
        loginForm.login(PITER_CHAILOVSKII);
        loginForm.checkUserInfo(PITER_CHAILOVSKII);
    }

    @AfterMethod
    public void afterMethod() {
        //logout after method
        loginForm.logout();
    }
}
