package homework.homework_2.ex2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

public class SmokeAndRegressionPresets {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

}
