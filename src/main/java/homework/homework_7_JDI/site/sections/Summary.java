package homework.homework_7_JDI.site.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Summary extends Section {

    @FindBy(css = ".horizontal-group p label")
    private RadioButtons allLabels;

    @FindBy(xpath = "//button[text() = 'Calculate']")
    private Button calculateButton;

    public void submitSum(List<Integer> values) {
//        values.stream().map(Integer::toString).forEach(allLabels::select);
        values.forEach(v -> allLabels.select(v.toString()));
    }

}
