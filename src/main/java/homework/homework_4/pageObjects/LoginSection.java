package homework.homework_4.pageObjects;

import com.codeborne.selenide.SelenideElement;
import homework.homework_4.entities.User;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;

public class LoginSection {

    @FindBy(css = ".uui-profile-menu")
    private SelenideElement dropdownProfileMenu;

    @FindBy(id = "Login")
    private SelenideElement userLogin;

    @FindBy(id = "Password")
    private SelenideElement userPassword;

    @FindBy(css = ".uui-button")
    private SelenideElement submitButton;

    @FindBy(css = ".profile-photo span")
    private SelenideElement profileInfo;

    @FindBy(css = ".logout")
    private SelenideElement logoutButton;

    public void login(User user) {
        dropdownProfileMenu.click();
        userLogin.sendKeys(user.getLogin());
        userPassword.sendKeys(user.getPassword());
        submitButton.click();
    }

    public void logout() {
        if (!logoutButton.isDisplayed())
            profileInfo.click();
        logoutButton.click();
        dropdownProfileMenu.click();
    }

    public void checkUserInfo(User user) {
        profileInfo.shouldHave(text(user.getUserName()));
    }
}
