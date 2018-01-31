package homework.homework_7_JDI.site;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import homework.homework_7_JDI.entities.User;
import homework.homework_7_JDI.site.pages.CommonPage;
import homework.homework_7_JDI.site.pages.HomePage;
import homework.homework_7_JDI.site.pages.MetalsColorsPage;

@JSite("https://epam.github.io/JDI/")
public class JDISite extends WebSite {

    public static CommonPage commonPage;
    public static HomePage homePage;
    public static MetalsColorsPage metalsColorsPage;

    public static void login(User user) {
        commonPage.header.loginForm.loginAsUser(user);
    }

    public static void checkUserInfo(User user) {
        commonPage.header.loginForm.checkUserInfo(user);
    }

}
