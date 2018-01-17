package additional_activity.vol2.pageObject;

import org.openqa.selenium.WebDriver;
import additional_activity.vol2.pageObject.pages.CommonPage;
import additional_activity.vol2.pageObject.pages.HomePage;
import additional_activity.vol2.utils.InitPageElements;

public class JDITestSite {

    public static HomePage homePage;

    public static CommonPage commonPage;

    private static WebDriver driver;

    public static void init(WebDriver driver) {
        JDITestSite.driver = driver;

        homePage = InitPageElements.initPages(driver, HomePage.class);
        commonPage = InitPageElements.initPages(driver, CommonPage.class);
    }


    public static void open() {
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
    }
}
