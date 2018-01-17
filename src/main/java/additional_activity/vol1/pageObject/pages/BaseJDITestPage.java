package additional_activity.vol1.pageObject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import additional_activity.vol1.pageObject.section.HeaderMenu;
import additional_activity.vol1.pageObject.section.LoginFormSection;

public class BaseJDITestPage {
    @FindBy(css = ".uui-profile-menu")
    WebElement userLoginMenu;

    @FindBy(css = ".profile-photo span")
    WebElement profileInfo;

    HeaderMenu headerMenu;

    LoginFormSection loginForm;
}
