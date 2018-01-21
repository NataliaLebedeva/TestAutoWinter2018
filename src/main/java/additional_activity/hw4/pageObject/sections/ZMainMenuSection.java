package additional_activity.hw4.pageObject.sections;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.function.Consumer;

public class ZMainMenuSection {

    public enum Z_PAGES {
        HOME, CONTACT_FORM
    }

    @FindBy(xpath = "//a[text()='Home']")
    public SelenideElement home;

    @FindBy(xpath = "//a[text()='Contact form']")
    public SelenideElement contactForm;

    static private HashMap<Z_PAGES, Consumer<ZMainMenuSection>> map = new HashMap<Z_PAGES, Consumer<ZMainMenuSection>>() {{
        put(Z_PAGES.HOME, p -> p.home.click());
        put(Z_PAGES.CONTACT_FORM, p -> p.contactForm.click());
    }};

    public void openPage(Z_PAGES page) {
        map.get(page).accept(this);
    }
}
