package homework.homework_2;

import homework.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class exerciseDPTest extends TestBase {

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {"practise", "To include good practices\n" +
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
    public void beforeMethod() {
        driver.get("https://jdi-framework.github.io/tests/index.htm");
    }

    @Test(dataProvider = "data")
    public void textBelowPicsTest(String title, String content) {
        String commonLocator = "//span[contains(@class,'%s')]/../../span";
        wait.until(ExpectedConditions.textToBe(By.xpath(String.format(commonLocator, title)), content));
    }
}
