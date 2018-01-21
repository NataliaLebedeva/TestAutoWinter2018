package homework.homework_4;

import homework.homework_4.pageObjects.CommonPage;
import homework.homework_4.pageObjects.DifferentElementsPage;
import homework.homework_4.pageObjects.IndexPage;
import homework.homework_4.pageObjects.LoginSection;

import static com.codeborne.selenide.Selenide.page;

public class JDISite {
    private static IndexPage indexPage;
    private static LoginSection loginForm;
    private static CommonPage common;
    private static DifferentElementsPage difElement;

    public static void init() {
        indexPage = page(IndexPage.class);
        loginForm = page(LoginSection.class);
        common = page(CommonPage.class);
        difElement = page(DifferentElementsPage.class);
    }
}
