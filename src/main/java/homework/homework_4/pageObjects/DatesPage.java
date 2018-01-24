package homework.homework_4.pageObjects;

import com.codeborne.selenide.Selenide;
import homework.homework_4.utils.elements.RangeSlider;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class DatesPage {

    private RangeSlider rangeSlider = new RangeSlider(
            $("[type='range']"),
            $(By.xpath("(//*[@type='range']//a)[1]")),
            $(By.xpath("(//*[@type='range']//a)[2]"))
    );

    public void setRangeSlider(int left, int right) {
        rangeSlider.setRange(left, right);
    }
}
