package homework.homework_4;

import homework.homework_4.pageObjects.CommonPage;
import homework.homework_4.pageObjects.DifferentElementsPage;
import homework.homework_4.pageObjects.HomePage;
import homework.homework_4.pageObjects.LoginSection;

import static com.codeborne.selenide.Selenide.page;

public class JDISite {
    public static HomePage homePage;
    public static LoginSection loginForm;
    public static CommonPage commonPage;
    public static DifferentElementsPage difElementPage;

    public static void init() {
        homePage = page(HomePage.class);
        loginForm = page(LoginSection.class);
        commonPage = page(CommonPage.class);
        difElementPage = page(DifferentElementsPage.class);
    }
}
