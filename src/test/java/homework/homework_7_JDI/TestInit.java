package homework.homework_7_JDI;

import com.epam.jdi.uitests.core.settings.JDISettings;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import homework.homework_7_JDI.site.JDISite;
import org.testng.annotations.BeforeSuite;

public class TestInit extends TestNGBase {

    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebSite.init(JDISite.class);
        JDISettings.logger.info("Run tests...");
    }
}
