package homework.homework_7_JDI.site;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import homework.homework_7_JDI.entities.User;
import homework.homework_7_JDI.site.pages.ContactPage;
import homework.homework_7_JDI.site.pages.HomePage;
import homework.homework_7_JDI.site.pages.MetalsColorsPage;

@JSite("https://epam.github.io/JDI/")
public class JDISite extends WebSite {

    @JPage(url = "/index.html", title = "Home Page")
    public static HomePage homePage;

    @JPage(url = "/metals-colors.html", title = "Metal and Colors")
    public static MetalsColorsPage metalsColorsPage;

    @JPage(url = "/contacts.html", title = "Contact Form")
    public static ContactPage contactPage;

    public static void login(User user) {
        homePage.header.loginForm.loginAsUser(user);
    }

    public static void checkUserInfo(User user) {
        homePage.header.loginForm.checkUserInfo(user);
    }

    public static void logout() {
        homePage.header.loginForm.logout();
    }
}
