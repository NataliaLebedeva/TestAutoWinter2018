package homework.homework_8_JDI;

import homework.homework_7_JDI.TestInit;
import homework.homework_7_JDI.entities.MetalsColorsFormData;
import homework.homework_7_JDI.entities.User;
import homework.homework_7_JDI.enums.JDI_PAGES;
import homework.homework_7_JDI.site.JDISite;
import homework.homework_8_JDI.utils.ResourceLoader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class MetalsColorsDataProviderTest extends TestInit{

    @BeforeMethod
    public void beforeMethod() {
        // 1. Login on JDI site as User
        JDISite.homePage.open();
        JDISite.login(User.PITER_CHAILOVSKII);
        JDISite.checkUserInfo(User.PITER_CHAILOVSKII);
    }

    @AfterMethod
    public void afterMethod() {
        JDISite.logout();
        JDISite.homePage.refresh();
    }

    @DataProvider
    public Object[][] getDataFromLoader() throws FileNotFoundException {
        Map<String, MetalsColorsFormData> map = ResourceLoader.getData();

        Object[] keys = map.keySet().toArray();
        Object[] values = map.values().toArray();
        Object[][] result = new Object[map.size()][2];
        for (int i = 0; i < map.size(); i++) {
            result[i][0] = keys[i];
            result[i][1] = values[i];
        }
        return result;
    }

    @Test(dataProvider = "getDataFromLoader")
    public void test1(String key, MetalsColorsFormData data) throws IOException {

        // 2. Open Metals & Colors page by Header menu
        JDISite.homePage.header.menu.selectItem(JDI_PAGES.METALS_COLORS);

        // 3. Fill form Metals & Colors by data
        JDISite.metalsColorsPage.metalsColorsForm.submit(data);

        // 4. Check Result section
        JDISite.metalsColorsPage.checkResult(data);
    }
}
