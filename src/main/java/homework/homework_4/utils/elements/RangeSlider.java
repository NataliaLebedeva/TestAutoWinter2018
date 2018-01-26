package homework.homework_4.utils.elements;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import homework.homework_4.utils.JDITestSiteLogger;
import lombok.AllArgsConstructor;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;

@AllArgsConstructor
public class RangeSlider {

    private static final int MAX = 100;
    private static final int MIN = 0;

    private SelenideElement root;
    private SelenideElement left;
    private SelenideElement right;

    public enum RANGE_ACTIONS {
        RANGE_LEFT("From"),
        RANGE_RIGHT("To");

        private String value;

        @Override
        public String toString() {
            return value;
        }

        RANGE_ACTIONS(String value) {
            this.value = value;
        }
    }

    public void setRange(int left, int right) {
        if (left == right && left == MAX) {
            setMaxPosition();
        } else if (left == right && left == MIN) {
            setMinPosition();
        } else {
            setRangeCommon(left, right);
        }
    }

    private void setToEdge(SelenideElement e, int edge) {
        new Actions(WebDriverRunner.getWebDriver())
                .clickAndHold(e)
                .pause(500)
                .moveByOffset(edge, 0)
                .release()
                .perform();
    }

    private void setMinPosition() {
        setToEdge(left, -300);
        JDITestSiteLogger.Add(RANGE_ACTIONS.RANGE_LEFT, MIN);
        setToEdge(right, -300);
        JDITestSiteLogger.Add(RANGE_ACTIONS.RANGE_RIGHT, MIN);
//        new Actions(WebDriverRunner.getWebDriver())
//                .clickAndHold(left)
//                .pause(500)
//                .moveByOffset(-300, 0)
//                .release()
//                .clickAndHold(right)
//                .pause(500)
//                .moveByOffset(-300, 0)
//                .release()
//                .perform();
    }

    private void setMaxPosition() {
        setToEdge(right, 300);
        JDITestSiteLogger.Add(RANGE_ACTIONS.RANGE_RIGHT, MAX);
        setToEdge(left, 300);
        JDITestSiteLogger.Add(RANGE_ACTIONS.RANGE_LEFT, MAX);
//        new Actions(WebDriverRunner.getWebDriver())
//                .clickAndHold(right)
//                .pause(500)
//                .moveByOffset(300, 0)
//                .release()
//                .clickAndHold(left)
//                .pause(500)
//                .moveByOffset(300, 0)
//                .release()
//                .perform();
    }

    private void setRangeCommon(int left, int right) {
        Selenide.executeJavaScript(
                "$(arguments[0]).slider( 'option', 'values', arguments[1] );",
                root,
                Arrays.asList(left, right));
        touchByStick(this.left);
        JDITestSiteLogger.Add(RANGE_ACTIONS.RANGE_LEFT, left);
        touchByStick(this.right);
        JDITestSiteLogger.Add(RANGE_ACTIONS.RANGE_RIGHT, right);
    }

    private void touchByStick(SelenideElement element) {
        new Actions(WebDriverRunner.getWebDriver())
                .clickAndHold(element)
                .pause(500)
                .moveByOffset(1, 0)
                .moveByOffset(-3, 0)
                .release().perform();
    }
}

