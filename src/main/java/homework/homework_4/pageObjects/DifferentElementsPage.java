package homework.homework_4.pageObjects;

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
