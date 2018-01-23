package homework.homework_4.utils.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

import static homework.homework_4.pageObjects.DifferentElementsPage.METALS;

@Getter
@AllArgsConstructor
public class MetalsRadioButtonGroup implements IShouldBeVisible {
    List<SelenideElement> elements;

    public void check(METALS metal) {
        elements.get(metal.ordinal()).click();
    }

    public METALS getChecked() {
        METALS current = null;
        for (int i = 0; i < elements.size(); i++) {
            if (!Objects.isNull(elements.get(i).getAttribute("checked"))) {
                current = METALS.values()[i];
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
