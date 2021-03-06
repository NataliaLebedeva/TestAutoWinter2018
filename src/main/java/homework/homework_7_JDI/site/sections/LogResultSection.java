package homework.homework_7_JDI.site.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.TextArea;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

public class LogResultSection extends Section {

    @FindBy(xpath = "//ul[contains(@class, 'logs')]")
    private TextArea logs;

    @FindBy(xpath = "//ul[contains(@class, 'results')]")
    public TextArea results;
}
