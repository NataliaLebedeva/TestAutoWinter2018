package homework.homework_4.utils.elements;

import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@AllArgsConstructor
public class RangeSlider {

    private SelenideElement root;
    private SelenideElement left;
    private SelenideElement right;

    public void setRange(int left, int right) {
        throw new NotImplementedException();
        //JS - executor to set up range, to refresh interface to fill up Logs//
    }
}
