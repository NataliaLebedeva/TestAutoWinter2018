package additional_activity.hw4;

import additional_activity.hw4.pageObject.ZJDISite;
import additional_activity.hw4.pageObject.sections.ZMainMenuSection;
import additional_activity.hw4.pageObject.sections.ZMainMenuSection.Z_PAGES;
import additional_activity.hw4.utils.ZUtils;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import homework.homework_4.entities.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static additional_activity.hw4.pageObject.sections.ZMainMenuSection.Z_PAGES.*;

public class Tests {

    @BeforeMethod
    public void beforeMethod() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;

        Configuration.timeout = 6000;
        Configuration.pollingInterval = 200;
        Configuration.collectionsPollingInterval = 300;

        ZUtils.init(ZJDISite.class);
    }

    @Test
    public void Test() {
        ZJDISite.open();

        ZJDISite.login(User.PITER_CHAILOVSKII);
        ZJDISite.homePage.loginForm.checkUserInfo(User.PITER_CHAILOVSKII);

        ZJDISite.homePage.mainMenu.openPage(CONTACT_FORM);
        ZJDISite.contactFormPage.observer.getLog();
        ZJDISite.contactFormPage.observer.getResult();
    }

    @AfterMethod
    public void afterMethod() {
        WebDriverRunner.closeWebDriver();
    }
}
