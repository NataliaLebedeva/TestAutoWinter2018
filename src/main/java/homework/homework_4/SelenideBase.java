package homework.homework_4;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static homework.homework_4.JDISite.init;

public class SelenideBase {
    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
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
