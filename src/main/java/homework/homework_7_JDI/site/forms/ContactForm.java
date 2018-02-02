package homework.homework_7_JDI.site.forms;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.CheckBox;
import com.epam.jdi.uitests.web.selenium.elements.common.TextArea;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import homework.homework_7_JDI.entities.UserContactInfo;
import homework.homework_7_JDI.site.sections.Summary;
import org.openqa.selenium.support.FindBy;

public class ContactForm extends Form<UserContactInfo> {

    private Summary summary;

    @FindBy(xpath = "//input[@id ='Name']")
    private TextField name;

    @FindBy(xpath = "//input[@id ='LastName']")
    private TextField lastName;

    @FindBy(xpath = "//textarea")
    private TextArea description;

    @FindBy(id="accept-conditions")
    private CheckBox acceptConditions;

    @FindBy(xpath = "//button[text() = 'Submit']")
    private Button submitButton;

    public void submit(UserContactInfo enquiredInfo) {
        name.newInput(enquiredInfo.getName());
        lastName.newInput(enquiredInfo.getLastName());
        description.inputLines(enquiredInfo.getDescription());
        acceptConditions.setValue(enquiredInfo.getIsAccepted().toString());
        summary.submitSum(enquiredInfo.getSummary());

        submitButton.click();
    }


}
