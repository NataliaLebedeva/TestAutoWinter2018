package additional_activity.hw4.pageObject.sections;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class ZObserverSection {

    @FindBy(xpath = "//div[contains(text(),'Log')]//..//ul")
    private SelenideElement log;

    @FindBy(xpath = "//div[contains(text(),'Result')]//..//ul")
    private SelenideElement result;

    public List<String> getLog() {
        return Arrays.asList(log.getText().split("\n"));
    }

    public List<String> getResult() {
        return Arrays.asList(result.getText().split("\n"));
    }
}
