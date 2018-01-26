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
