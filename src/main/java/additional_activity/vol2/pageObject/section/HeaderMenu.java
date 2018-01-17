package additional_activity.vol2.pageObject.section;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu {
    public enum PAGES {
        HOME, CONTACT_FORM, METALS_COLORS
    }

    @FindBy(xpath = "//a[text()='Home']")
    WebElement home;

    @FindBy(xpath = "//a[text()='Contact form']")
    WebElement contactForm;

    @FindBy(xpath = "//a[text()='Metals & Colors']")
    WebElement metalsColors;

    public void open(PAGES page) {
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
        }
    }

}
