package homework.homework_3.pageObjects;

import homework.TestBase;
import homework.homework_3.entities.User;
import homework.homework_3.enums.Benefits;
import homework.homework_3.enums.MainTextEnum;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

import static homework.DriverFactory.*;
import static homework.TestBase.*;
import static homework.homework_3.enums.MainTextEnum.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

    @FindBy(css = ".benefit-txt")
    private List<WebElement> benefitText;

    @FindBy(css = ".benefit-icon")
    private List<WebElement> benefitIcon;

    @FindBy(css = ".main-txt")
    private WebElement mainText;

    @FindBy(css = ".main-title")
    private WebElement mainTitle;

    public void open() {
        //2. Open index page
        GetDriver().get("https://jdi-framework.github.io/tests/index.htm");
        //3. Assert Browser title
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

    public void checkBenefitIcons() {
        Assert.assertEquals(benefitIcon.size(), Benefits.values().length);
        for (WebElement e : benefitIcon) {
            assertTrue(e.isDisplayed());
        }
    }

    public void checkBenefitsTexts() {
        List<String> actual = benefitText.stream()
                .map(WebElement::getText)
                .map(REPLACE_NEW_LINE)
                .collect(Collectors.toList());
        Assert.assertEquals(actual, Benefits.AsList());
    }

    public void checkMainText() {
        assertEquals(mainTitle.getText(), MAIN_TITLE.getText());
        assertEquals(mainText.getText(), MAIN_TEXT.getText());
    }
}
