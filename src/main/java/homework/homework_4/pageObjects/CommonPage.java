package homework.homework_4.pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.function.Consumer;

public class CommonPage {
    public enum JDI_SITE_PAGES {
        HOME, CONTACT_FORM, METALS_COLORS
    }

    @FindBy(css = "header a[href='index.htm']")
    public SelenideElement home;

    //as xPath it will be shorter:  "//a[text()='Contact form']"
    @FindBy(css = "header li:not(.dropdown) a[href='page1.htm']")
    public SelenideElement contactForm;

    @FindBy(css = "header [class='dropdown']")
    public SelenideElement service;

    @FindBy(css = "header a[href='page2.htm']")
    public SelenideElement metalsColors;

    @FindBy(css = ".sidebar-menu a[href='index.htm']")
    public SelenideElement home2;

    @FindBy(css = ".sidebar-menu a[href='page1.htm']")
    public SelenideElement contactForm2;

    @FindBy(css = ".sidebar-menu [class='sub-menu']")
    public SelenideElement service2;

    @FindBy(css = ".sidebar-menu a[href='page2.htm']")
    public SelenideElement metalsColors2;

    static private HashMap<JDI_SITE_PAGES, Consumer<CommonPage>> map =
            new HashMap<JDI_SITE_PAGES, Consumer<CommonPage>>() {{
                put(JDI_SITE_PAGES.HOME, p -> p.home.click());
                put(JDI_SITE_PAGES.CONTACT_FORM, p -> p.contactForm.click());
                put(JDI_SITE_PAGES.METALS_COLORS, p -> p.metalsColors.click());
                put(JDI_SITE_PAGES.HOME, p -> p.home2.click());
                put(JDI_SITE_PAGES.CONTACT_FORM, p -> p.contactForm2.click());
                put(JDI_SITE_PAGES.METALS_COLORS, p -> p.metalsColors2.click());

            }};

    public void openPage(JDI_SITE_PAGES page) {
        map.get(page).accept(this);
    }
}
