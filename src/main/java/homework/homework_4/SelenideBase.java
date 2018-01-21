package homework.homework_4;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import homework.homework_4.pageObjects.IndexPage;
import homework.homework_4.pageObjects.LoginSection;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static homework.homework_4.entities.User.PITER_CHAILOVSKII;

public class SelenideBase {

    static IndexPage indexPage;
    static LoginSection loginForm;

    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;

        Configuration.timeout = 6000;
        Configuration.pollingInterval = 200;
        Configuration.collectionsPollingInterval = 300;

        JDISite.init();

        open("https://jdi-framework.github.io/tests/index.htm");
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverRunner.closeWebDriver();
    }

    @BeforeMethod
    public void beforeMethod() {
        loginForm.login(PITER_CHAILOVSKII);
        loginForm.checkUserInfo(PITER_CHAILOVSKII);
    }

    @AfterMethod
    public void afterMethod() {
        loginForm.logout();
    }
}
