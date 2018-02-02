package homework.homework_7_JDI;

import homework.homework_7_JDI.entities.MetalsColorsFormData;
import homework.homework_7_JDI.entities.User;
import homework.homework_7_JDI.entities.UserContactInfo;
import homework.homework_7_JDI.enums.JDI_PAGES;
import homework.homework_7_JDI.site.JDISite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JDISiteMetalsColorsTest extends TestInit {

    @BeforeMethod
    public void beforeMethod() {
        // 1. Login on JDI site as User
        JDISite.homePage.open();
        JDISite.login(User.PITER_CHAILOVSKII);
        JDISite.checkUserInfo(User.PITER_CHAILOVSKII);
    }

    @AfterMethod
    public void afterMethod() {
        JDISite.logout();
        JDISite.homePage.refresh();
    }

    @Test
    public void metalsColorsTest() {

        // 2. Open Metals & Colors page by Header menu
        JDISite.homePage.header.menu.selectItem(JDI_PAGES.METALS_COLORS);

        // 3. Fill form Metals & Colors by data
        JDISite.metalsColorsPage.metalsColorsForm.submit(MetalsColorsFormData.DEFAULT);

        // 4. Check Result section
        JDISite.metalsColorsPage.checkResult(MetalsColorsFormData.DEFAULT);

    }



    @Test
    public void contactTest(){

        // 2. Open Contact page
        JDISite.metalsColorsPage.header.menu.selectItem(JDI_PAGES.CONTACT_FORM);

        // 3. Fill contact form
        JDISite.contactPage.contactForm.submit(UserContactInfo.USER_CONTACT_INFO);

        // 4. Check result section
        JDISite.contactPage.checkResult(UserContactInfo.USER_CONTACT_INFO);
    }


}
