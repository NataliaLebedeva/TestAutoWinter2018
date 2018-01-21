package additional_activity.hw3_BarStyle;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import homework.homework_4.entities.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;

public class LoginFormPageObj {

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
        profileInfo.click();
        logoutButton.click();
    }

    public class MyCondition extends Condition {
        public MyCondition(String name) {
            super(name);
        }

        @Override
        public boolean apply(WebElement element) {
            return false;
        }
    }

    public void checkUserInfo(User user) {
        profileInfo.should(new Condition("textIgnoreCase") {
            @Override
            public boolean apply(WebElement element) {

                return element.getText().equalsIgnoreCase(user.getUserName());
            }
        });
        profileInfo.should(new MyCondition(""));
        profileInfo.shouldHave(Condition.text(user.getUserName()));
        assertEquals(profileInfo.text().toLowerCase(), user.getUserName().toLowerCase());
    }
}

