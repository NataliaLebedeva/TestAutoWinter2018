package homework.homework_4;

import homework.homework_4.pageObjects.DifferentElementsPage;
import homework.homework_4.pageObjects.DifferentElementsPage.COLORS;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static homework.homework_4.JDISite.*;
import static homework.homework_4.entities.User.PITER_CHAILOVSKII;
import static homework.homework_4.pageObjects.CommonPage.JDI_SITE_PAGES.DIFFERENT_ELEMENTS;
import static homework.homework_4.pageObjects.CommonPage.JDI_SITE_PAGES.SERVICE;
import static homework.homework_4.pageObjects.CommonPage.MENU_TYPE.HEADER;
import static homework.homework_4.pageObjects.CommonPage.MENU_TYPE.SIDE_BAR;
import static homework.homework_4.pageObjects.DifferentElementsPage.COLORS.*;
import static homework.homework_4.pageObjects.DifferentElementsPage.METALS.SELEN;
import static homework.homework_4.pageObjects.DifferentElementsPage.NATURE_ELEMENT.FIRE;
import static homework.homework_4.pageObjects.DifferentElementsPage.NATURE_ELEMENT.WATER;
import static homework.homework_4.pageObjects.DifferentElementsPage.NATURE_ELEMENT.WIND;

public class JDISiteTest1 extends SelenideBase {

    @BeforeMethod
    public void beforeMethod() {
        //1. perform login before every method
        loginForm.login(PITER_CHAILOVSKII);
        //2. check user info
        loginForm.checkUserInfo(PITER_CHAILOVSKII);
    }

    @AfterMethod
    public void afterMethod() {
        //logout after method
        loginForm.logout();
    }

    @Test
    public void differentElementsTest() {

        //3. check interface of the home page
        homePage.checkPageTitle();
        homePage.checkBenefitsTextsStream();
        homePage.checkBenefitsIcon();
        homePage.checkMainText();

        //4. click on "Service" subcategory in the header and check that drop down contains options
        commonPage.openPage(HEADER, SERVICE);
        commonPage.checkSubMenu(HEADER);

        //5. click on "Service" subcategory in the left section and check that drop down contains options
        commonPage.openPage(SIDE_BAR, SERVICE);
        commonPage.checkSubMenu(SIDE_BAR);

        //6. Open through the header menu Service -> Different Elements Page
        commonPage.openPage(HEADER, DIFFERENT_ELEMENTS);

        //7. Check interface on Service page, it contains all needed elements.
        difElementPage.checkInterface();

        //8. Select and assert checkboxes Water, Wind
        difElementPage.setNatureElement(WATER, WIND);

        //9. Select radio
        difElementPage.selectMetal(SELEN);

        //10. Select in dropdown Yellow
        difElementPage.selectColor(YELLOW);
        //11. Check in logs section selected values and status

//        difElementPage.selectMetal(GOLD);
//        difElementPage.selectMetal(SILVER);
    }


}
