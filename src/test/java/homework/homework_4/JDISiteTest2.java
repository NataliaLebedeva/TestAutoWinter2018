package homework.homework_4;

import org.testng.annotations.Test;

import static homework.homework_4.JDISite.commonPage;
import static homework.homework_4.JDISite.datesPage;
import static homework.homework_4.pageObjects.CommonPage.JDI_SITE_PAGES.DATES;
import static homework.homework_4.pageObjects.CommonPage.MENU_TYPE.HEADER;

public class JDISiteTest2 extends SelenideBase {

    @Test
    public void test2() {
        // 8. Open Service -> Dates
        commonPage.openPage(HEADER, DATES);

        datesPage.setRangeSlider(0, 100);
    }

}
