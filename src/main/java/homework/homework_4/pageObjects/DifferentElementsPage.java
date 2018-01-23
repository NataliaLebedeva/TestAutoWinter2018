package homework.homework_4.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.*;
import static homework.homework_4.pageObjects.DifferentElementsPage.ACTIONS.*;

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

    //NATURE_ELEMENTS
    @FindBy(xpath = "//*[text()[contains(.,'Water')]]//input")
    public SelenideElement water;
    @FindBy(xpath = "//*[text()[contains(.,'Earth')]]//input")
    public SelenideElement earth;
    @FindBy(xpath = "//*[text()[contains(.,'Wind')]]//input")
    public SelenideElement wind;
    @FindBy(xpath = "//*[text()[contains(.,'Fire')]]//input")
    public SelenideElement fire;


    //METALS
    @FindBy(xpath = "//*[text()[contains(.,'Gold')]]//input")
    public SelenideElement gold;
    @FindBy(xpath = "//*[text()[contains(.,'Silver')]]//input")
    public SelenideElement silver;
    @FindBy(xpath = "//*[text()[contains(.,'Bronze')]]//input")
    public SelenideElement bronze;
    @FindBy(xpath = "//*[text()[contains(.,'Selen')]]//input")
    public SelenideElement selen;

    //COLORS
    @FindBy(css = ".colors")
    public SelenideElement colors;
    @FindBy(css = ".uui-form-element option")
    public List<SelenideElement> listOfColors;

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
        Stream<SelenideElement> elements = Stream.of(water, earth, wind, fire,
                gold, silver, bronze, selen, colors, defaultButton, simpleButton, logs, results);
        elements.forEach(e -> e.shouldBe(visible));

    }

    public static HashMap<Object, List<ACTIONS>> actionsLog = new HashMap<>();

    public void setNatureElement(NATURE_ELEMENT... elements) {
        for (NATURE_ELEMENT element : elements) {
            switch (element) {
                case WATER:
                    water.click();
                    break;
                case EARTH:
                    earth.click();
                    break;
                case WIND:
                    wind.click();
                    break;
                case FIRE:
                    fire.click();
                    break;
            }
            log(element, SET_ELEMENT);
        }
    }

    public void unsetNatureElement(NATURE_ELEMENT... elements) {
        for (NATURE_ELEMENT element : elements) {
            switch (element) {
                case WATER:
                    water.click();
                    break;
                case EARTH:
                    earth.click();
                    break;
                case WIND:
                    wind.click();
                    break;
                case FIRE:
                    fire.click();
                    break;
            }
            log(element, UNSET_ELEMENT);
        }
    }

    public void selectMetal(METALS metal) {
        switch (metal) {
            case GOLD:
                gold.click();
                break;
            case SILVER:
                silver.click();
                break;
            case BRONZE:
                bronze.click();
                break;
            case SELEN:
                selen.click();
        }
        log(metal, SELECT_METAL);
    }

    public void selectColor(COLORS color) {
        switch (color) {
            case RED:
                colors.click();
                listOfColors.get(0).click();
                break;
            case GREEN:
                colors.click();
                listOfColors.get(1).click();
                break;
            case BLUE:
                colors.click();
                listOfColors.get(2).click();
                break;
            case YELLOW:
                colors.click();
                listOfColors.get(3).click();
                break;
        }
          log(color, SELECT_COLOR);
    }

    public void checkNatureElement() {

    }

    private static void log(Object element, ACTIONS action) {
        if (!actionsLog.containsKey(element)) {
            actionsLog.put(element, new ArrayList<>());
        }
        actionsLog.get(element).add(action);
    }

}
