package homework.homework_3;

import homework.homework_3.data.User;
import homework.homework_3.pageObjects.IndexPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class IndexPageTest {

    private WebDriver driver = new ChromeDriver();

    public void indexPageTest() {
        IndexPageObject indexPage = PageFactory.initElements(driver, IndexPageObject.class);
        indexPage.open();
        indexPage.login(new User("epam", "1234"));
        indexPage.checkUserInfo();
        indexPage.checkTextBelowPic();
        indexPage.checkMainText();
    }
}
