package homework.homework_4.pageObjects;

import com.codeborne.selenide.SelenideElement;
import com.google.common.collect.Lists;
import homework.homework_4.utils.elements.ColorsDropdown;
import homework.homework_4.utils.elements.IShouldBeVisible;
import homework.homework_4.utils.elements.MetalsRadioButtonGroup;
import homework.homework_4.utils.elements.NatureElementsCheckbox;
import lombok.val;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DifferentElementsPage {

    public enum NATURE_ELEMENT {
        WATER, EARTH, WIND, FIRE;
    }

    public enum METALS {
        GOLD, SILVER, BRONZE, SELEN;
    }

    public enum COLORS {
        RED, GREEN, BLUE, YELLOW;
    }

    public enum ACTIONS {
        SET_ELEMENT, UNSET_ELEMENT, SELECT_METAL, SELECT_COLOR;
    }

    private NatureElementsCheckbox natureElementsCheckbox = new NatureElementsCheckbox("[type='checkbox']");

    private MetalsRadioButtonGroup metals = new MetalsRadioButtonGroup($$(".label-radio input"));

    private ColorsDropdown colorsDropdown = new ColorsDropdown(
            $(".colors .uui-form-element"),
            $$(".uui-form-element option")
    );

    // other elements
    @FindBy(css = ".uui-button[value ='Default Button']")
    public SelenideElement defaultButton;
    @FindBy(css = ".uui-button[value ='Button']")
    public SelenideElement simpleButton;

    @FindBy(xpath = "//ul[contains(@class, 'logs')]")
    public SelenideElement logs;
    @FindBy(xpath = "//ul[contains(@class, 'results')]")
    public SelenideElement results;

    public void checkInterface() {
        Stream.of(natureElementsCheckbox, metals, colorsDropdown).forEach(IShouldBeVisible::shouldBeVisible);
        Stream.of(defaultButton, simpleButton, logs, results).forEach(se -> se.shouldBe(visible));
    }

    public void setNatureElement(NATURE_ELEMENT... elements) {
        for (val element : elements) {
            natureElementsCheckbox.check(element);
            totalLogs.add(String.format("%s: condition changed to true", element.toString()));
        }
    }

    public void unsetNatureElement(NATURE_ELEMENT... elements) {
        for (NATURE_ELEMENT element : elements) {
            natureElementsCheckbox.unCheck(element);
            totalLogs.add(String.format("%s: condition changed to false", element.toString()));
        }
    }

    public void selectMetal(METALS metal) {
        metals.check(metal);
        totalLogs.add(String.format("metal: value changed to %s", metal.toString()));
    }

    public void selectColor(COLORS color) {
        colorsDropdown.select(color);
        totalLogs.add(String.format("Colors: value changed to %s", color.toString()));
    }

    /// LOG

    public static List<String> totalLogs = new ArrayList<>();

    public static void checkLog(DifferentElementsPage difElementPage) {
        String expectedLog = Lists
                .reverse(DifferentElementsPage.totalLogs).stream()
                .collect(Collectors.joining("|"))
                .toLowerCase()
                .replaceAll(" ", "");

        String actualLog = Arrays.stream(difElementPage.logs.getText().split("\n"))
                .map(s -> s.replaceAll("(\\d{2}:\\d{2}:\\d{2})", ""))
                .collect(Collectors.joining("|"))
                .toLowerCase()
                .replaceAll(" ", "");

        Assert.assertEquals(expectedLog, actualLog);
    }

}
