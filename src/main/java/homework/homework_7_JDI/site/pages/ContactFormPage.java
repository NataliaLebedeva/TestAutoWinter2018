package homework.homework_7_JDI.site.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextArea;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

@JPage(url = "/contacts.html", title = "Contact Form")
public class ContactFormPage extends WebPage {

    @FindBy(css = "[id ='Name']")
    private TextField name;

    @FindBy(css = "[id ='LastName']")
    private TextField lastName;

    @FindBy(xpath = "//textarea")
    private TextArea description;

    @FindBy(xpath = "//button[text() = 'Submit']")
    private Button submit;

    @FindBy(xpath = "(//*[@class = 'horizontal-group'])[1]")
    private RadioButtons firstLine;

    @FindBy(xpath = "(//*[@class = 'horizontal-group'])[2]")
    private RadioButtons secondLine;

    @FindBy(xpath = "//button[text() = 'Calculate']")
    private Button calculateButton;
}
