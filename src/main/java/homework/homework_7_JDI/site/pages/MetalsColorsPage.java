package homework.homework_7_JDI.site.pages;

import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import homework.homework_7_JDI.entities.MetalsColorsFormData;
import homework.homework_7_JDI.site.forms.MetalsColorsForm;

@JPage(url = "/metals-colors.html", title = "Metal and Colors")
public class MetalsColorsPage extends CommonPage {
    public MetalsColorsForm metalsColorsForm;

    public void checkResult(MetalsColorsFormData aDefault) {
    }
}
