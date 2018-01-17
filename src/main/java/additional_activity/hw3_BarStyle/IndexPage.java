package additional_activity.hw3_BarStyle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends Page {

    @FindBy(css = ".uui-profile-menu")
    private WebElement userLoginMenu;

    @FindBy(css = "Login")
    private WebElement userLogin;

    @FindBy(css = "Password")
    private WebElement userPassword;

    @FindBy(css = ".uui-button")
    private WebElement submitButton;

    @FindBy(css = ".profile-photo span")
    private WebElement profileInfo;

    @FindBy(css = ".main-txt")
    private WebElement mainText;

    @FindBy(css = ".main-title")
    private WebElement mainTitle;

    /// METHODS ///


    public void open() {
        driver.get("https://jdi-framework.github.io/tests/index.htm");
    }

    public IndexPage(WebDriver driver) {
        super(driver);
    }
}
