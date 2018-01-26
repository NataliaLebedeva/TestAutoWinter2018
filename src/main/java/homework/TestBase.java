package homework;

import org.testng.annotations.BeforeSuite;

import java.security.PublicKey;
import java.util.function.Function;

import static java.lang.System.setProperty;

public class TestBase {

    public static Function<String, String> REPLACE_NEW_LINE = (s) -> s.replaceAll("\n", " ");

    @BeforeSuite
    public void beforeSuite() {
        setProperty("webdriver.chrome.driver", "chromedriver.exe");;
    }

}
