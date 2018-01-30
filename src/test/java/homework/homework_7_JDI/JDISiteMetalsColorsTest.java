package homework.homework_7_JDI;

import homework.homework_7_JDI.entities.User;
import homework.homework_7_JDI.enums.JDI_SITE_PAGES;
import homework.homework_7_JDI.site.JDISite;
import org.testng.annotations.Test;

public class JDISiteMetalsColorsTest extends TestInit {

    @Test
    public void metalsColorsTest() {
        // 1. Login on JDI site as User
        JDISite.homePage.open();
        JDISite.login(User.PITER_CHAILOVSKII);
        JDISite.loginForm.checkUserInfo(User.PITER_CHAILOVSKII);

        // 2. Open Metals & Colors page by Header menu
//        JDISite.header.menu.
        JDISite.header.openMenu(JDI_SITE_PAGES.CONTACT_FORM);
//        JDISite.headerMenu.hoverAndClick(JDI_SITE_PAGES.CONTACT_FORM);

    }
}
