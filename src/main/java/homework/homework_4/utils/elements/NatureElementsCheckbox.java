package homework.homework_4.utils.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.impl.BySelectorCollection;
import homework.homework_4.enums.NatureElements;
import homework.homework_4.utils.JDITestSiteLogger;
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

    public List<NatureElements> getChecked() {
        List<NatureElements> checked = new ArrayList<>();
        val items = gen();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).isChecked())
                checked.add(NatureElements.values()[i]);
        }
        return checked;
    }

    public void check(NatureElements element) {
        gen().get(element.ordinal()).check();
        JDITestSiteLogger.Add(element, true);
    }

    public void unCheck(NatureElements element) {
        gen().get(element.ordinal()).unCheck();
        JDITestSiteLogger.Add(element, false);
    }

    @Override
    public void shouldBeVisible() {
        gen().forEach(MyCheckbox::shouldBeVisible);
    }
}
