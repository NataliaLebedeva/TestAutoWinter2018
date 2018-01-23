package homework.homework_4;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.open;
import static homework.homework_4.JDISite.init;

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
}
