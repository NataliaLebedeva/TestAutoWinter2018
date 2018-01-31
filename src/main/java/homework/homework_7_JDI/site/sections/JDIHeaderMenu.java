package homework.homework_7_JDI.site.sections;


import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import homework.homework_7_JDI.enums.JDI_PAGES;

public class JDIHeaderMenu<T extends JDI_PAGES> extends Menu<T> {

    public void selectItem(T item) {
        if(item.getLevel() == 2)
            super.select(T.SERVICE.toString());
        super.select(item.toString());
    }
}
