package additional_activity.vol2.pageObject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import additional_activity.vol2.entities.User;
import additional_activity.vol2.pageObject.Factory;
import additional_activity.vol2.pageObject.section.HeaderMenu;
import additional_activity.vol2.pageObject.section.LoginFormSection;

public class CommonPage {
    @FindBy(css = ".uui-profile-menu")
    WebElement userLoginMenu;

    @FindBy(css = ".profile-photo span")
    WebElement profileInfo;

    @Factory
    public HeaderMenu headerMenu;

    @Factory
    public LoginFormSection loginForm;

    public void login(User user) {
        userLoginMenu.click();
        loginForm.submit(user);
    }

    public String getProfileInfo(){
        return profileInfo.getText();
    }
}
