package homework.homework_4.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static homework.homework_4.pageObjects.CommonPage.JDI_SITE_PAGES.*;

public class CommonPage {
    public enum JDI_SITE_PAGES {
        HOME, CONTACT_FORM, METALS_COLORS, SERVICE, SUPPORT, DIFFERENT_ELEMENTS, DATES
    }

    public enum MENU_TYPE {
        HEADER, SIDE_BAR
    }

    @FindBy(css = "header a[href='index.htm']")
    public SelenideElement home;

    //as xPath it will be shorter:  "//a[text()='Contact form']"
    @FindBy(css = "header li:not(.dropdown) a[href='page1.htm']")
    public SelenideElement contactForm;

    @FindBy(css = "header [class*='dropdown'] a[href='page1.htm']")
    public SelenideElement service;

    // SERVICES
    @FindBy(css = "header a[href='page3.htm']")
    public SelenideElement support;

    @FindBy(css = "header a[href='page4.htm']")
    public SelenideElement dates;

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
                elements = Stream.of(support, dates, differentElements);
                break;
            case SIDE_BAR:
                throw new NotImplementedException();
                // TODO
//                elements = Stream.of(sideSupport, sideDates, sideDifferentElements);
                // break;
        }

        Assert.assertTrue(elements.allMatch(SelenideElement::isDisplayed));
        headerActions.get(SERVICE).accept(this);
    }
}
