package homework.homework_4.utils.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.impl.BySelectorCollection;
import homework.homework_4.pageObjects.DifferentElementsPage.NATURE_ELEMENT;
import lombok.Getter;
import lombok.val;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class NatureElementsCheckbox implements IShouldBeVisible {
    private BySelectorCollection selectorCollection;

    private List<MyCheckbox> gen() {
        return new ElementsCollection(selectorCollection).stream().map(MyCheckbox::new).collect(Collectors.toList());
    }

    public NatureElementsCheckbox(String css) {
        this(By.cssSelector(css));
    }

    public NatureElementsCheckbox(By selectorCollection) {
        this.selectorCollection = new BySelectorCollection(selectorCollection);
    }

    public List<NATURE_ELEMENT> getChecked() {
        List<NATURE_ELEMENT> checked = new ArrayList<>();
        val items = gen();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).isChecked())
                checked.add(NATURE_ELEMENT.values()[i]);
        }
        return checked;
    }

    public void check(NATURE_ELEMENT element) {
        gen().get(element.ordinal()).check();
    }

    public void unCheck(NATURE_ELEMENT element) {
        gen().get(element.ordinal()).unCheck();
    }

    @Override
    public void shouldBeVisible() {
        gen().forEach(MyCheckbox::shouldBeVisible);
    }
}
