package homework.homework_7_JDI.site.forms;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import homework.homework_7_JDI.entities.User;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginForm extends Form<User> {

    @FindBy(id = "Login")
    private TextField login;

    @FindBy(id = "Password")
    private TextField password;

    @FindBy(css = ".profile-photo")
    private Label profilePhoto;

    @FindBy(css = ".profile-photo span")
    private Text profileInfo;

    @FindBy(css = ".fa-sign-out")
    private Label signOut;

    @FindBy(css = ".uui-button")
    private Button submitButton;

    public void loginAsUser(User user) {
        profilePhoto.click();
        this.loginAs(user);
    }

    public void checkUserInfo(User user) {
        Assert.assertTrue(profileInfo.getText().equalsIgnoreCase(user.getUserName()));
    }

    public void logout() {
        if (!signOut.isDisplayed())
            profilePhoto.click();
        signOut.click();
    }
}
