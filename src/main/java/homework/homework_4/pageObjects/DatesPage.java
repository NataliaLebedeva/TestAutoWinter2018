package homework.homework_4.pageObjects;

import com.codeborne.selenide.SelenideElement;
import homework.homework_4.utils.JDITestSiteLogger;
import homework.homework_4.utils.elements.RangeSlider;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;

public class DatesPage {

    @FindBy(xpath = "//ul[contains(@class, 'logs')]")
    private SelenideElement logs;

    @FindBy(xpath = "//ul[contains(@class, 'results')]")
    private SelenideElement results;

    private RangeSlider rangeSlider = new RangeSlider(
            $(".uui-slider.range"),
            $(By.xpath("(//*[@type='range']//a)[1]")),
            $(By.xpath("(//*[@type='range']//a)[2]"))
    );

    @Step
    public void setRangeSlider(int left, int right) {
            rangeSlider.setRange(left, right);
    }

    @Step
    public void checkLog() {
        JDITestSiteLogger.Check(logs.getText());
    }

    @Step
    public void checkLogCount() {
        JDITestSiteLogger.CheckCount(logs.getText());}

}
