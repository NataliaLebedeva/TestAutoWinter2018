package homework.homework_7_JDI.site.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import homework.homework_7_JDI.enums.Colors;
import homework.homework_7_JDI.enums.Metals;
import homework.homework_7_JDI.enums.NatureElements;
import homework.homework_7_JDI.enums.Vegetables;

@JPage(url = "/metals-colors.html", title = "Metal and Colors")
public class MetalsColorsPage extends WebPage {


    public void setSummary(int i, int j) {
    }

    public void setElements(NatureElements... elements) {
    }

    public void setColor(Colors color) {
    }

    public void setMetal(Metals metal) {

    }

    public void setVegetables(Vegetables... vegs) {
    }

    public void submit() {
    }
}
