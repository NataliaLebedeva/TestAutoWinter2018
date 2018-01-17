package additional_activity.vol1.pageObject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import additional_activity.vol1.entities.User;
import additional_activity.vol1.pageObject.section.HeaderMenu;
import additional_activity.vol1.pageObject.section.LoginFormSection;

public class HomePage extends BaseJDITestPage {

    @FindBy(css = ".main-txt")
    private WebElement mainText;

    @FindBy(css = ".main-title")
    private WebElement mainTitle;

    public void login(User user) {
        userLoginMenu.click();
        loginForm.submit(user);
    }

    public String getProfileInfo(){
        return profileInfo.getText();
    }

    public static HomePage getInstance(WebDriver driver) {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.loginForm = LoginFormSection.getInstance(driver);
        homePage.headerMenu = HeaderMenu.getInstance(driver);

        return homePage;
    }
}
