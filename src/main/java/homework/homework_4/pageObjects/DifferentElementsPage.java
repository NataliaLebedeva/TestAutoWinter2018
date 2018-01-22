package homework.homework_4.pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static homework.homework_4.pageObjects.DifferentElementsPage.ACTIONS.*;

public class DifferentElementsPage {

    public enum NATURE_ELEMENT {
        WATER, EARTH, WIND, FIRE
    }

    public enum METALS {
        GOLD, SILVER, BRONZE, SELEN
    }

    public enum ACTIONS {
        SET_ELEMENT, UNSET_ELEMENT, SELECT_METAL, SELECT_COLOR
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


    public static HashMap<Object, List<ACTIONS>> actionsLog = new HashMap<>();

    public void setNatureElement(NATURE_ELEMENT... elements) {
        for (NATURE_ELEMENT element : elements) {
            // SelenideCode
            log(element, SET_ELEMENT);
        }
    }

    public void unsetNatureElement(NATURE_ELEMENT... elements) {
        for (NATURE_ELEMENT element : elements) {
            // SelenideCode
            log(element, UNSET_ELEMENT);
        }
    }

    public void selectMetal(METALS metal) {
        // SelenideCode
        log(metal, SELECT_METAL);
    }

    private static void log(Object element, ACTIONS action) {
        if (!actionsLog.containsKey(element)) {
            actionsLog.put(element, new ArrayList<>());
        }
        actionsLog.get(element).add(action);
    }

    public void checkNatureElement() {

    }

}
