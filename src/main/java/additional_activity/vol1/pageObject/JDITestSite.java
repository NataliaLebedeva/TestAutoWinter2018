package additional_activity.vol1.pageObject;

import org.openqa.selenium.WebDriver;
import additional_activity.vol1.pageObject.pages.HomePage;

public class JDITestSite {

//    public static ContactPage contactFormPage;
    public static HomePage homePage;

    private static WebDriver driver;

    public static void init(WebDriver driver){
        homePage = HomePage.getInstance(driver);
        JDITestSite.driver = driver;
    }

    public static void open() {
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
    }
}
