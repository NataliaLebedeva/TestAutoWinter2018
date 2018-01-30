package homework.homework_4;

import homework.homework_4.utils.AllureAttachmentListener;
import homework.homework_4.utils.JDITestSiteLogger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static homework.homework_4.JDISite.*;
import static homework.homework_4.entities.User.PITER_CHAILOVSKII;
import static homework.homework_4.enums.Colors.YELLOW;
import static homework.homework_4.enums.Metals.SELEN;
import static homework.homework_4.enums.NatureElements.WATER;
import static homework.homework_4.enums.NatureElements.WIND;
import static homework.homework_4.pageObjects.CommonPage.JDI_SITE_PAGES.DIFFERENT_ELEMENTS;
import static homework.homework_4.pageObjects.CommonPage.JDI_SITE_PAGES.SERVICE;
import static homework.homework_4.pageObjects.CommonPage.MENU_TYPE.HEADER;
import static homework.homework_4.pageObjects.CommonPage.MENU_TYPE.SIDE_BAR;

@Listeners(AllureAttachmentListener.class)
@Features({"Selenide Test Suite"})
@Stories({"Login and Different elements tests"})
public class JDISiteDifferentElementsPageTest extends SelenideBase {

    @Test
    public void differentElementsTest() {
        // 4. Open site by URL
        JDISite.openSite();
        // 5. perform login before every method
        loginForm.login(PITER_CHAILOVSKII);
        // 6. check user info
        loginForm.checkUserInfo(PITER_CHAILOVSKII);

        // 7. check interface of the home page
        homePage.checkPageTitle();
        homePage.checkBenefitsTextsByStream();
        homePage.checkBenefitsIcon();
        homePage.checkMainText();

        // 8. click on "Service" subcategory in the header and check that drop down contains options
        commonPage.openPage(HEADER, SERVICE);
        commonPage.checkSubMenu(HEADER);

        // 9. click on "Service" subcategory in the left section and check that drop down contains options
        commonPage.openPage(SIDE_BAR, SERVICE);
        commonPage.checkSubMenu(SIDE_BAR);

        // 10. Open through the header menu Service -> Different Elements Page
        commonPage.openPage(HEADER, DIFFERENT_ELEMENTS);

        // 11. Check interface on Service page, it contains all needed elements.
        difElementPage.checkInterface();

        // 12. Select and assert checkboxes Water, Wind
        difElementPage.setNatureElement(WATER, WIND);

        // 13. Select radio
        difElementPage.selectMetal(SELEN);

        // 14. Select in dropdown Yellow
        difElementPage.selectColor(YELLOW);

        // 15. Check in logs section selected values and status
        difElementPage.checkLog();

        // 16. Unselect and assert checkboxes
        difElementPage.unsetNatureElement(WATER, WIND);

        // 17. Check in logs section unselected values and status
        difElementPage.checkLog();

        //logout after every  test-method
        loginForm.logout();
    }

    @AfterMethod
    public void afterMethod() {
        JDITestSiteLogger.CleanLog();
    }
}
