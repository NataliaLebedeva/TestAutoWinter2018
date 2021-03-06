package homework.homework_4;

import homework.homework_4.utils.AllureAttachmentListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static homework.homework_4.JDISite.*;
import static homework.homework_4.entities.User.PITER_CHAILOVSKII;
import static homework.homework_4.pageObjects.CommonPage.JDI_SITE_PAGES.DATES;
import static homework.homework_4.pageObjects.CommonPage.MENU_TYPE.HEADER;

@Listeners(AllureAttachmentListener.class)
@Features({"Selenide Test Suite"})
@Stories({"Login and drag'n'drop tests"})
public class JDISiteDatesPageTest extends SelenideBase {

    @Test
    public void dragAndDropTest() {
        // 4. Open site by URL
        JDISite.openSite();

        // 5. perform login before every method
        loginForm.login(PITER_CHAILOVSKII);

        // 6. check user info
        loginForm.checkUserInfo(PITER_CHAILOVSKII);

        // 8. Open Service -> Dates
        commonPage.openPage(HEADER, DATES);

        // 9. Using drag-and-drop set Range sliders.
        // left sliders - the most left position, right slider - the most rigth position
        datesPage.setRangeSlider(0, 100);

        // 10. Using drag-and-drop set Range sliders. Both sliders to left position
        datesPage.setRangeSlider(0, 0);

        // 11. Using drag-and-drop set Range sliders. Both sliders to right position
        datesPage.setRangeSlider(100, 100);

        // 12. Using drag-and-drop set Range sliders.
        datesPage.setRangeSlider(30, 70);

        // 13. Check log count
        datesPage.checkLog();

        //logout after every  test-method
        loginForm.logout();
    }

}
