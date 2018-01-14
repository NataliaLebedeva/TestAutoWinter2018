package homework.homework_2;

import homework.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class exerciseDPTest extends TestBase {

    @DataProvider
    public Object[][] data() {
        return new Object[][] {
                {"practise","To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM projec"},
                {"custom", "To be flexible and\n" +
                        "customizable"},
                {"multi", "To be multiplatform"},
                {"base", "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more\u2026"},
        };
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.get("https://jdi-framework.github.io/tests/index.htm");
        wait.until(ExpectedConditions.titleIs("Index Page"));
    }


}
