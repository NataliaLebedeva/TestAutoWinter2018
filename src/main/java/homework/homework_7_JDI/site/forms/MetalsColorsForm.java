package homework.homework_7_JDI.site.forms;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import homework.homework_7_JDI.entities.MetalsColorsFormData;
import org.openqa.selenium.support.FindBy;

public class MetalsColorsForm extends Form<MetalsColorsFormData> {

    @FindBy(css = "")
    private RadioButtons summary1;

    @FindBy(css = "")
    private RadioButtons summary2;

    @FindBy(css = "")
    private CheckList elements;

    @FindBy(css = "")
    private Dropdown color;

    @FindBy(css = "")
    private TextField metals;

    @FindBy(css = "")
    private CheckList vegetables;

    @FindBy(css = "")
    private Button submit;

    public void submit(MetalsColorsFormData mc) {
        summary1.select(mc.getSummary().get(0));
        summary2.select(mc.getSummary().get(1));
        mc.getElements().forEach(elements::select);
        color.select(mc.getColor());
        metals.newInput(mc.getMetal());
        mc.getVegetables().forEach(vegetables::select);

        submit.click();
    }
}
