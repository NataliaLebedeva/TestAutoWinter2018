package homework.homework_7_JDI.site;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import homework.homework_7_JDI.entities.User;
import homework.homework_7_JDI.site.pages.HomePage;
import homework.homework_7_JDI.site.sections.Header;
import homework.homework_7_JDI.site.sections.LoginForm;
import homework.homework_7_JDI.site.sections.SideMenu;

@JSite("https://epam.github.io/JDI/")
public class JDISite extends WebSite {
    public static HomePage homePage;
    public static LoginForm loginForm;
    public static Header header;
    public static SideMenu sideMenu;

    public static void login(User user) {
        loginForm.loginAsUser(user);
    }

}
