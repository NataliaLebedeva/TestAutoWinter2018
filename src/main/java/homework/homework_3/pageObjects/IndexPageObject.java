package homework.homework_3.pageObjects;

import homework.homework_3.entities.User;
import homework.homework_3.enums.IndexPageTextEnum;
import homework.homework_3.enums.MainTextEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class IndexPageObject extends Page {

    @FindBy(css = ".uui-profile-menu")
    private WebElement dropdownProfileMenu;

    @FindBy(id = "Login")
    private WebElement userLogin;

    @FindBy(id = "Password")
    private WebElement userPassword;

    @FindBy(css = ".uui-button")
    private WebElement submitButton;

    @FindBy(css = ".profile-photo span")
    private WebElement profileInfo;

    @FindAll(
            @FindBy(css = ".benefit-txt")
    )
    private List<WebElement> benefitTxt;


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
        dropdownProfileMenu.click();
        userLogin.sendKeys(user.getLogin());
        userPassword.sendKeys(user.getPassword());
        submitButton.click();
    }

    public void checkUserInfo(User user) {
        assertEquals(profileInfo.getText().toLowerCase(), user.getUserName().toLowerCase());
    }

    public void checkTextBelowPic() {
        IndexPageTextEnum[] values = IndexPageTextEnum.values();
        for (int i = 0; i < values.length; i++) {
            assertEquals(benefitTxt.get(i).getText().replaceAll("\n", " "), values[i].getText());
        }
    }

    public void checkMainText() {
        MainTextEnum[] values = MainTextEnum.values();
        assertEquals(mainTitle.getText(), values[0].getText());
        assertEquals(mainText.getText(), values[1].getText());
    }
}
