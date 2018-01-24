package homework.homework_4.pageObjects;

import com.codeborne.selenide.SelenideElement;
import homework.homework_4.enums.Colors;
import homework.homework_4.enums.Metals;
import homework.homework_4.enums.NatureElements;
import homework.homework_4.utils.JDITestSiteLogger;
import homework.homework_4.utils.elements.ColorsDropdown;
import homework.homework_4.utils.elements.IShouldBeVisible;
import homework.homework_4.utils.elements.MetalsRadioButtonGroup;
import homework.homework_4.utils.elements.NatureElementsCheckbox;
import lombok.val;
import org.openqa.selenium.support.FindBy;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DifferentElementsPage {

    private NatureElementsCheckbox natureElementsCheckbox = new NatureElementsCheckbox("[type='checkbox']");

    private MetalsRadioButtonGroup metals = new MetalsRadioButtonGroup($$(".label-radio input"));

    private ColorsDropdown colorsDropdown = new ColorsDropdown(
            $(".colors .uui-form-element"),
            $$(".uui-form-element option")
    );

    // other elements
    @FindBy(css = ".uui-button[value ='Default Button']")
    private SelenideElement defaultButton;
    @FindBy(css = ".uui-button[value ='Button']")
    private SelenideElement button;

    @FindBy(xpath = "//ul[contains(@class, 'logs')]")
    private SelenideElement logs;
    @FindBy(xpath = "//ul[contains(@class, 'results')]")
    private SelenideElement results;

    public void checkInterface() {
        Stream.of(natureElementsCheckbox, metals, colorsDropdown).forEach(IShouldBeVisible::shouldBeVisible);
        Stream.of(defaultButton, button, logs, results).forEach(se -> se.shouldBe(visible));
    }

    public void setNatureElement(NatureElements... elements) {
        for (val element : elements) {
            natureElementsCheckbox.check(element);
        }
    }

    public void unsetNatureElement(NatureElements... elements) {
        for (val element : elements) {
            natureElementsCheckbox.unCheck(element);
        }
    }

    public void selectMetal(Metals metal) {
        metals.check(metal);
    }

    public void selectColor(Colors color) {
        colorsDropdown.select(color);
    }

    public void checkLog() {
        JDITestSiteLogger.Check(logs.getText());
    }

}
