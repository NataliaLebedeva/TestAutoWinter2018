package homework.homework_4;

import homework.homework_4.pageObjects.DifferentElementsPage;
import org.testng.annotations.Test;

import static homework.homework_4.JDISite.commonPage;
import static homework.homework_4.JDISite.difElementPage;
import static homework.homework_4.JDISite.homePage;
import static homework.homework_4.pageObjects.CommonPage.JDI_SITE_PAGES.DIFFERENT_ELEMENTS;
import static homework.homework_4.pageObjects.CommonPage.JDI_SITE_PAGES.SERVICE;
import static homework.homework_4.pageObjects.CommonPage.MENU_TYPE.HEADER;
import static homework.homework_4.pageObjects.DifferentElementsPage.METALS.*;
import static homework.homework_4.pageObjects.DifferentElementsPage.NATURE_ELEMENT.*;

public class JDISiteTest1 extends SelenideBase {

    @Test
    public void indexPageTest() {
        homePage.checkPageTitle();
        homePage.checkBenefitsTextsStream();
        homePage.checkBenefitsIcon();
        homePage.checkMainText();
        commonPage.openPage(HEADER, SERVICE);
        commonPage.checkSubMenu(HEADER);

//        commonPage.openPage(SIDE_BAR, SERVICE);
//        commonPage.checkSubMenu(SIDE_BAR);

        commonPage.openPage(HEADER, DIFFERENT_ELEMENTS);
        difElementPage.setNatureElement(EARTH, WIND, FIRE);
        difElementPage.selectMetal(SILVER);
        difElementPage.selectMetal(GOLD);
        difElementPage.selectMetal(SILVER);
    }


}
