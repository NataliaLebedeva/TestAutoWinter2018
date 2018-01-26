package homework.homework_3.pageObjects;

import homework.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
    protected WebDriverWait wait;

    public Page() {
        wait = new WebDriverWait(DriverFactory.GetDriver(), 10);
    }
}
