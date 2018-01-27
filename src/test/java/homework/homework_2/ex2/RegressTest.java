package homework.homework_2.ex2;

import homework.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static homework.DriverFactory.GetDriver;

public class RegressTest extends TestBase {
    private static final String USERNAME = "Piter Chailovskii";

    private WebDriverWait wait;

    @BeforeClass()
    public void beforeClass() {
        GetDriver().get("https://jdi-framework.github.io/tests/index.htm");
        wait = new WebDriverWait(GetDriver(), 10);
    }

    @AfterClass()
    public void afterClass() {
        //10. Close Browser
        GetDriver().close();
    }

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

    @Test(dataProvider = "data", groups = "regression")
    public void textCompareTest(String title, String content) {
        String commonLocator = "//span[contains(@class,'%s')]/../../span";
        wait.until(ExpectedConditions.textToBe(By.xpath(String.format(commonLocator, title)), content));
    }

    @Test(groups = "regression")
    public void loginTest() {
        GetDriver().findElement(By.cssSelector(".uui-profile-menu")).click();
        GetDriver().findElement(By.id("Login")).sendKeys("epam");
        GetDriver().findElement(By.id("Password")).sendKeys("1234");
        GetDriver().findElement(By.cssSelector(".uui-button")).click();
        WebElement profileInfo = GetDriver().findElement(By.cssSelector(".profile-photo span"));
        Assert.assertTrue(USERNAME.equalsIgnoreCase(profileInfo.getText()));
    }
}
