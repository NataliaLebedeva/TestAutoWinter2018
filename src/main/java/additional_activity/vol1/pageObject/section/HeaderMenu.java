package additional_activity.vol1.pageObject.section;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public static HeaderMenu getInstance(WebDriver driver) {
        return PageFactory.initElements(driver, HeaderMenu.class);
    }

}
