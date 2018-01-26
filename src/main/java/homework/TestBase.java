package homework;

import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

public class TestBase {

    @BeforeSuite
    public void beforeSuite() {
        setProperty("webdriver.chrome.driver", "chromedriver.exe");;
    }

}
