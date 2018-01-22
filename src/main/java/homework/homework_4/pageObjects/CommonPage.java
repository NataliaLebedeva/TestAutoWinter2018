package homework.homework_4.pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.visible;
import static homework.homework_4.pageObjects.CommonPage.JDI_SITE_PAGES.*;

public class CommonPage {
    public enum JDI_SITE_PAGES {
        HOME, CONTACT_FORM, METALS_COLORS, SERVICE, SUPPORT, DATES, COMPLEX_TABLE, SIMPLE_TABLE, TABLE_WITH_PAGES, DIFFERENT_ELEMENTS
    }

    public enum MENU_TYPE {
        HEADER, SIDE_BAR
    }

    @FindBy(css = "header a[href='index.htm']")
    public SelenideElement home;

    //as xPath :  "//a[text()='Contact form']"
    @FindBy(css = "header li:not(.dropdown) a[href='page1.htm']")
    public SelenideElement contactForm;

    @FindBy(css = "header [class*='dropdown'] a[href='page1.htm']")
    public SelenideElement service;

    // SERVICES
    @FindBy(css = "header a[href='page3.htm']")
    public SelenideElement support;

    @FindBy(css = "header a[href='page4.htm']")
    public SelenideElement dates;

    @FindBy(css = "header a[href='page5.htm']")
    public SelenideElement completxTable;

    @FindBy(css = "header a[href='page6.htm']")
    public SelenideElement simpleTable;

    @FindBy(css = "header a[href='page7.htm']")
    public SelenideElement tablePages;

    @FindBy(css = "header a[href='page8.htm']")
    public SelenideElement differentElements;
    //

    @FindBy(css = "header a[href='page2.htm']")
    public SelenideElement metalsColors;

    @FindBy(css = ".sidebar-menu a[href='index.htm']")
    public SelenideElement sideHome;

    @FindBy(css = ".sidebar-menu a[href='page1.htm']")
    public SelenideElement sideContactForm;

    @FindBy(css = ".sidebar-menu [class='sub-menu']")
    public SelenideElement sideService;

    @FindBy(css = ".sidebar-menu a[href='page2.htm']")
    public SelenideElement sideMetalsColors;

    //servises on side bar
    @FindBy(css = ".sidebar-menu a[href='page3.htm']")
    public SelenideElement sideSupport;

    @FindBy(css = ".sidebar-menu a[href='page4.htm']")
    public SelenideElement sideDates;

    @FindBy(css = ".sidebar-menu a[href='page5.htm']")
    public SelenideElement sideComplexTable;

    @FindBy(css = ".sidebar-menu a[href='page6.htm']")
    public SelenideElement sideSimpleTable;

    @FindBy(css = ".sidebar-menu a[href='page7.htm']")
    public SelenideElement sideTablePages;

    @FindBy(css = ".sidebar-menu a[href='page8.htm']")
    public SelenideElement sideDifferentElements;
    //

    static private HashMap<JDI_SITE_PAGES, Consumer<CommonPage>> headerActions =
            new HashMap<JDI_SITE_PAGES, Consumer<CommonPage>>() {{
                put(HOME, p -> p.home.click());
                put(CONTACT_FORM, p -> p.contactForm.click());
                put(METALS_COLORS, p -> p.metalsColors.click());
                put(SERVICE, p -> p.service.click());
                put(SUPPORT, p -> {
                    p.service.click();
                    p.support.click();
                });
                put(DATES, p -> {
                    p.service.click();
                    p.dates.click();
                });
                put(COMPLEX_TABLE, p -> {
                    p.service.click();
                    p.completxTable.click();
                });
                put(SIMPLE_TABLE, p -> {
                    p.service.click();
                    p.simpleTable.click();
                });
                put(TABLE_WITH_PAGES, p -> {
                    p.service.click();
                    p.tablePages.click();
                });
                put(DIFFERENT_ELEMENTS, p -> {
                    p.service.click();
                    p.differentElements.click();
                });
            }};

    static private HashMap<JDI_SITE_PAGES, Consumer<CommonPage>> sideBarActions =
            new HashMap<JDI_SITE_PAGES, Consumer<CommonPage>>() {{
                put(HOME, p -> p.sideHome.click());
                put(CONTACT_FORM, p -> p.sideContactForm.click());
                put(METALS_COLORS, p -> p.sideMetalsColors.click());
                put(SERVICE, p -> p.sideService.click());
                put(SUPPORT, p -> {
                    p.sideService.click();
                    p.sideSupport.click();
                });
                put(DATES, p -> {
                    p.sideService.click();
                    p.sideDates.click();
                });
                put(COMPLEX_TABLE, p -> {
                    p.sideService.click();
                    p.sideComplexTable.click();
                });
                put(SIMPLE_TABLE, p -> {
                    p.sideService.click();
                    p.sideSimpleTable.click();
                });
                put(TABLE_WITH_PAGES, p -> {
                    p.sideService.click();
                    p.sideTablePages.click();
                });
                put(DIFFERENT_ELEMENTS, p -> {
                    p.sideService.click();
                    p.sideDifferentElements.click();
                });
            }};

    public void openPage(MENU_TYPE menuType, JDI_SITE_PAGES page) {
        HashMap<JDI_SITE_PAGES, Consumer<CommonPage>> map = null;
        switch (menuType) {
            case HEADER:
                map = headerActions;
                break;
            case SIDE_BAR:
                map = sideBarActions;
                break;
        }
        map.get(page).accept(this);
    }

    public void checkSubMenu(MENU_TYPE type) {
        Stream<SelenideElement> elements = null;
        switch (type) {
            case HEADER:
                elements = Stream.of(support, dates, completxTable, simpleTable, tablePages, differentElements);
                elements.forEach(e -> e.shouldBe(visible));
                headerActions.get(SERVICE).accept(this);
                break;
            case SIDE_BAR:
                elements = Stream.of(sideSupport, sideDates, sideComplexTable, sideSimpleTable, sideTablePages, sideDifferentElements);
                elements.forEach(e -> e.shouldBe(visible));
                sideBarActions.get(SERVICE).accept(this);
        }
    }


}
