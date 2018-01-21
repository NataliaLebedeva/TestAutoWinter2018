package additional_activity.hw4.pageObject;

import additional_activity.hw4.utils.factory.ZPage;
import additional_activity.hw4.pageObject.pages.ZContactFormPage;
import additional_activity.hw4.pageObject.pages.ZHomePage;
import com.codeborne.selenide.Selenide;
import homework.homework_4.entities.User;

public class ZJDISite {
    @ZPage
    public static ZHomePage homePage;

    @ZPage
    public static ZContactFormPage contactFormPage;

    public static void open() {
        Selenide.open("https://jdi-framework.github.io/tests/index.htm");
    }

    public static void login(User user) {
        homePage.loginForm.login(user);
    }
}