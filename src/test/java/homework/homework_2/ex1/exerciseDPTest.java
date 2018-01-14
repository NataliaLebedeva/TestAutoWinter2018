package homework.homework_2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class exerciseDPTest extends DataProviderParallelBase {
    @DataProvider(parallel = true)
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


    @Test(dataProvider = "data")
    public void textBelowPicsTest(String title, String content) throws InterruptedException {
        webDriverLocal.get().get("https://jdi-framework.github.io/tests/index.htm");
        new WebDriverWait(webDriverLocal.get(), 10)
                .until(ExpectedConditions.textToBe(
                        By.xpath(String.format("//span[contains(@class,'%s')]/../../span", title)),
                        content));
    }
}
