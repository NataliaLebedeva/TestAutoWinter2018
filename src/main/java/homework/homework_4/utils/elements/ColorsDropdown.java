package homework.homework_4.utils.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import homework.homework_4.pageObjects.DifferentElementsPage.COLORS;
import lombok.AllArgsConstructor;
import lombok.val;

import java.util.List;


@AllArgsConstructor
public class ColorsDropdown implements ISelenideElement, IShouldBeVisible {
    private SelenideElement root;
    private List<SelenideElement> items;

    public COLORS getSelected() {
        val index = Integer.parseInt(root.getAttribute("selectedIndex"));
        return COLORS.values()[index];
    }

    public void select(COLORS color) {
        if (!getSelected().equals(color)) {
            root.click();
            items.get(color.ordinal()).click();
        }
    }

    @Override
    public SelenideElement getSelenideElement() {
        return root;
    }

    @Override
    public void shouldBeVisible() {
        root.shouldBe(Condition.visible);
    }
}
