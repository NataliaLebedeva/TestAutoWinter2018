package homework.homework_4;

import org.testng.annotations.Test;

import static homework.homework_4.JDISite.*;
import static homework.homework_4.pageObjects.CommonPage.JDI_SITE_PAGES.DIFFERENT_ELEMENTS;
import static homework.homework_4.pageObjects.CommonPage.JDI_SITE_PAGES.SERVICE;
import static homework.homework_4.pageObjects.CommonPage.MENU_TYPE.HEADER;
import static homework.homework_4.pageObjects.CommonPage.MENU_TYPE.SIDE_BAR;
import static homework.homework_4.pageObjects.DifferentElementsPage.METALS.GOLD;
import static homework.homework_4.pageObjects.DifferentElementsPage.METALS.SILVER;
import static homework.homework_4.pageObjects.DifferentElementsPage.NATURE_ELEMENT.*;

public class JDISiteTest1 extends SelenideBase {

    @Test
    public void indexPageTest() {

        //check interfase of the home page
        homePage.checkPageTitle();
        homePage.checkBenefitsTextsStream();
        homePage.checkBenefitsIcon();
        homePage.checkMainText();

        //click on "Service" subcategory in the header and check that drop down contains options
        commonPage.openPage(HEADER, SERVICE);
        commonPage.checkSubMenu(HEADER);

        //click on "Service" subcategory in the left section and check that drop down contains options
        commonPage.openPage(SIDE_BAR, SERVICE);
        commonPage.checkSubMenu(SIDE_BAR);

        //Open through the header menu Service -> Different Elements Page
        commonPage.openPage(HEADER, DIFFERENT_ELEMENTS);

        //Check interface on Service page, it contains all needed elements.

//        difElementPage.setNatureElement(EARTH, WIND, FIRE);
//        difElementPage.selectMetal(SILVER);
//        difElementPage.selectMetal(GOLD);
//        difElementPage.selectMetal(SILVER);
    }


}
