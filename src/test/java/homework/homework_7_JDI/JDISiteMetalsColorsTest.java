package homework.homework_7_JDI;

import homework.homework_7_JDI.entities.User;
import homework.homework_7_JDI.enums.JDI_PAGES;
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
        JDISite.header.menu.selectItem(JDI_PAGES.METALS_COLORS);

        // 3. Fill form Metals & Colors by data


    }
}
