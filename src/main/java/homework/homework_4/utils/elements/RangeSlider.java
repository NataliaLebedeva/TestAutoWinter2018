package homework.homework_4.utils.elements;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import lombok.AllArgsConstructor;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;

@AllArgsConstructor
public class RangeSlider {

    private SelenideElement root;
    private SelenideElement left;
    private SelenideElement right;

    public void setRange(int left, int right) {
        Selenide.executeJavaScript(
                "$(arguments[0]).slider( 'option', 'values', arguments[1] );",
                root,
                Arrays.asList(left, right));
        touchByStick(this.left);
        //add From log
        touchByStick(this.right);
        //add To log
    }

    private void touchByStick(SelenideElement element) {
        new Actions(WebDriverRunner.getWebDriver())
                .clickAndHold(element)
                .moveByOffset(1, 0)
                .moveByOffset(-3, 0)
                .release().perform();
    }
}

