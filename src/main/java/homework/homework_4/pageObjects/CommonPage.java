package homework.homework_4.pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

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
    private SelenideElement home;

    //as xPath :  "//a[text()='Contact form']"
    @FindBy(css = "header li:not(.dropdown) a[href='page1.htm']")
    private SelenideElement contactForm;

    @FindBy(css = "header [class*='dropdown'] a[href='page1.htm']")
    private SelenideElement service;

    // SERVICES
    @FindBy(css = "header a[href='page3.htm']")
    private SelenideElement support;

    @FindBy(css = "header a[href='page4.htm']")
    private SelenideElement dates;

    @FindBy(css = "header a[href='page5.htm']")
    private SelenideElement completxTable;

    @FindBy(css = "header a[href='page6.htm']")
    private SelenideElement simpleTable;

    @FindBy(css = "header a[href='page7.htm']")
    private SelenideElement tablePages;

    @FindBy(css = "header a[href='page8.htm']")
    private SelenideElement differentElements;

    @FindBy(css = "header a[href='page2.htm']")
    private SelenideElement metalsColors;

    @FindBy(css = ".sidebar-menu a[href='index.htm']")
    private SelenideElement sideHome;

    @FindBy(css = ".sidebar-menu a[href='page1.htm']")
    private SelenideElement sideContactForm;

    //@FindBy(css = ".sidebar-menu [class='sub-menu']")
    @FindBy(css = "[class='sub-menu'] a[href='page1.htm']")
    private SelenideElement sideService;

    @FindBy(css = ".sidebar-menu a[href='page2.htm']")
    private SelenideElement sideMetalsColors;

    //servises on side bar
    @FindBy(css = ".sidebar-menu a[href='page3.htm']")
    private SelenideElement sideSupport;

    @FindBy(css = ".sidebar-menu a[href='page4.htm']")
    private SelenideElement sideDates;

    @FindBy(css = ".sidebar-menu a[href='page5.htm']")
    private SelenideElement sideComplexTable;

    @FindBy(css = ".sidebar-menu a[href='page6.htm']")
    private SelenideElement sideSimpleTable;

    @FindBy(css = ".sidebar-menu a[href='page7.htm']")
    private SelenideElement sideTablePages;

    @FindBy(css = ".sidebar-menu a[href='page8.htm']")
    private SelenideElement sideDifferentElements;

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

    @Step
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

    @Step
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
