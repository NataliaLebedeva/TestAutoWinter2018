package additional_activity.vol1.pageObject.section;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import additional_activity.vol1.entities.User;

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

    public static LoginFormSection getInstance(WebDriver driver) {
        return PageFactory.initElements(driver, LoginFormSection.class);
    }
}
