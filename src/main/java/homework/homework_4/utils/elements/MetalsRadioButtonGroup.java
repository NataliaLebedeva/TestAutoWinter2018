package homework.homework_4.utils.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import homework.homework_4.enums.Metals;
import homework.homework_4.utils.JDITestSiteLogger;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
@AllArgsConstructor
public class MetalsRadioButtonGroup implements IShouldBeVisible {
    List<SelenideElement> elements;

    public void check(Metals metal) {
        elements.get(metal.ordinal()).click();
        JDITestSiteLogger.Add(metal);
    }

    public Metals getChecked() {
        Metals current = null;
        for (int i = 0; i < elements.size(); i++) {
            if (!Objects.isNull(elements.get(i).getAttribute("checked"))) {
                current = Metals.values()[i];
                break;
            }
        }
        return current;
    }

    @Override
    public void shouldBeVisible() {
        elements.forEach(e -> e.shouldBe(Condition.visible));
    }
}
