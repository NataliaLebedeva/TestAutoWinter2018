package homework.homework_4;

import homework.homework_4.utils.JDITestSiteLogger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static homework.homework_4.JDISite.init;
import static homework.homework_4.JDISite.loginForm;
import static homework.homework_4.entities.User.PITER_CHAILOVSKII;

public class SelenideBase {

    @BeforeMethod
    public void beforeMethod() {
        // 4. Open site by URL
        open("https://jdi-framework.github.io/tests/index.htm");
        // 5. perform login before every method
        loginForm.login(PITER_CHAILOVSKII);
        // 6. check user info
        loginForm.checkUserInfo(PITER_CHAILOVSKII);
    }

    @AfterMethod
    public void afterMethod() {
        //logout after every  test-method
        loginForm.logout();
        JDITestSiteLogger.CleanLog();
    }

    @BeforeSuite
    public void beforeSuite() {
        browser = "chrome";
        startMaximized = true;

        timeout = 6000;
        pollingInterval = 200;
        collectionsPollingInterval = 300;

        init();
    }

    @AfterSuite
    public void afterSuite() {
        //close driver after non-parallel test methods
        closeWebDriver();
    }
}
