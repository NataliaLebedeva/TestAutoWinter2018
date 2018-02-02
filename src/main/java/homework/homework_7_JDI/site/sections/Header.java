package homework.homework_7_JDI.site.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import homework.homework_7_JDI.enums.JDI_PAGES;
import homework.homework_7_JDI.site.forms.LoginForm;
import homework.homework_7_JDI.site.elements.JDIHeaderMenu;
import org.openqa.selenium.support.FindBy;

public class Header extends Section {

    public LoginForm loginForm;
//    public SearchSection searchSection;

    @FindBy(css = ".m-l8")
    public JDIHeaderMenu<JDI_PAGES> menu;

    @FindBy(css = ".search")
    public Button searchButton;

    @FindBy(css = ".search-field input")
    public TextField searching;

}
