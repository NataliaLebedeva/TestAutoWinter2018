package additional_activity.vol2.pageObject.section;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import additional_activity.vol2.entities.User;

public class LoginFormSection {
    @FindBy(id = "Login")
    WebElement userLogin;

    @FindBy(id = "Password")
    WebElement userPassword;

    @FindBy(css = ".uui-button")
    WebElement submitButton;

    public void submit(User user) {
        userLogin.sendKeys(user.getLogin());
        userPassword.sendKeys(user.getPassword());
        submitButton.click();
    }

}
