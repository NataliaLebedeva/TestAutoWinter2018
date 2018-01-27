package homework.homework_4.pageObjects;

import com.codeborne.selenide.SelenideElement;
import homework.homework_4.entities.User;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.text;

public class LoginSection {

    @FindBy(css = ".uui-profile-menu")
    private SelenideElement dropdownProfileMenu;

    @FindBy(css = ".col-sm-9 [id ='Login']")
    private SelenideElement userLogin;

    @FindBy(css = ".col-sm-9 [id ='Password']")
    private SelenideElement userPassword;

    @FindBy(css = ".uui-button")
    private SelenideElement submitButton;

    @FindBy(css = ".profile-photo span")
    private SelenideElement profileInfo;

    @FindBy(css = ".logout")
    private SelenideElement logoutButton;

    @Step("Login as user")
    public void login(User user) {
        dropdownProfileMenu.click();
        userLogin.sendKeys(user.getLogin());
        userPassword.sendKeys(user.getPassword());
        submitButton.click();
    }

    @Step
    public void logout() {
        if (!logoutButton.isDisplayed())
            profileInfo.click();
        logoutButton.click();
    }

    @Step
    public void checkUserInfo(User user) {
        profileInfo.shouldHave(text(user.getUserName()));
    }
}
