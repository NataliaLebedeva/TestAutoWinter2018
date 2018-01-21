package additional_activity.hw4.pageObject.pages;

import additional_activity.hw4.pageObject.pages.base.ZBasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class ZHomePage extends ZBasePage {
    @FindBy(css = ".main-title")
    public SelenideElement mainTitle;

    @FindBy(css = ".main-txt")
    public SelenideElement mainText;
}
