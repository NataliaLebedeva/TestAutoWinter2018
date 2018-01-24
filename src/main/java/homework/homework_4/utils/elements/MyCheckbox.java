package homework.homework_4.utils.elements;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
public class MyCheckbox implements ISelenideElement, IShouldBeVisible {

    private SelenideElement element;

    public void check() {
        if (!isChecked()) {
            element.click();
        }
    }

    public void unCheck() {
        if (isChecked())
            element.click();
    }

    public boolean isChecked() {
        return !Objects.isNull(element.getAttribute("checked"));
    }

    @Override
    public SelenideElement getSelenideElement() {
        return element;
    }

    @Override
    public void shouldBeVisible() {
        element.shouldBe(Condition.visible);
    }
}
