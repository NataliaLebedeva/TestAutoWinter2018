package homework.homework_3.pageObjects;

import homework.homework_3.data.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.*;

public class IndexPageObject extends Page {

    @FindBy(id = "Login")
    private WebElement userLogin;

    @FindBy(id = "Password")
    private WebElement userPassword;

    @FindBy(css = ".uui-button")
    private WebElement submitButton;

    @FindBy(css = ".profile-photo span")
    private WebElement profileInfo;

    @FindBy(css = ".main-txt")
    private WebElement mainText;

    @FindBy(css = ".main-title")
    private WebElement mainTitle;

    public IndexPageObject(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://jdi-framework.github.io/tests/index.htm");
        wait.until(ExpectedConditions.titleIs("Index Page"));
    }

    public void login(User user) {
        userLogin.sendKeys(user.getLogin());
        userPassword.sendKeys(user.getPassword());
        submitButton.click();
    }

    public void checkUserInfo(User user) {
        assertEquals(profileInfo.getText(), user.getUserName());
    }

    public void checkTextBelowPic() {

    }

    public void checkMainText() {

    }
}
