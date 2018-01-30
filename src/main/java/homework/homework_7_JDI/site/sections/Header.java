package homework.homework_7_JDI.site.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Link;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import homework.homework_7_JDI.enums.JDI_SITE_PAGES;
import org.openqa.selenium.support.FindBy;

public class Header extends Menu {
//
//    @FindBy(css = ".m-l8")
//    public IMenu menu1;
//
//    @JMenu(
//            level1 = @JFindBy(css = ".uui-navigation.nav.navbar-nav.m-l8>li>a"),
//            level2 = @JFindBy(css = ".dropdown-menu>li>a")
//    )
//    public IMenu menu;

    @FindBy(css = "header a[href='index.htm']")
    private Link home;

    @FindBy(xpath = "//a[text()='Contact form']")
    private Link contactForm;

    @FindBy(css = "header a[href='page2.htm']")
    private Link metalsColors;

    public void openMenu(JDI_SITE_PAGES page) {
        switch (page) {
            case HOME:
                home.click();
                break;
            case CONTACT_FORM:
                contactForm.click();
                break;
            case METALS_COLORS:
                metalsColors.click();
                break;
            case SERVICE:
                break;
            case SUPPORT:
                break;
            case DATES:
                break;
            case COMPLEX_TABLE:
                break;
            case SIMPLE_TABLE:
                break;
            case TABLE_WITH_PAGES:
                break;
            case DIFFERENT_ELEMENTS:
                break;
        }

    }

}
