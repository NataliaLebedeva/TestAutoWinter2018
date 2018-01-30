package homework.homework_4;

import homework.homework_4.pageObjects.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class JDISite {
    public static HomePage homePage;
    public static LoginSection loginForm;
    public static CommonPage commonPage;
    public static DifferentElementsPage difElementPage;
    public static DatesPage datesPage;

    static void init() {
        homePage = page(HomePage.class);
        loginForm = page(LoginSection.class);
        commonPage = page(CommonPage.class);
        difElementPage = page(DifferentElementsPage.class);
        datesPage = page(DatesPage.class);
    }

    public static void openSite() {
        open("https://jdi-framework.github.io/tests/index.htm");
    }
}
