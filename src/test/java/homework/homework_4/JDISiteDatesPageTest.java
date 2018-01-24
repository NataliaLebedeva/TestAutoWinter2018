package homework.homework_4;

import org.testng.annotations.Test;

import static homework.homework_4.JDISite.commonPage;
import static homework.homework_4.JDISite.datesPage;
import static homework.homework_4.pageObjects.CommonPage.JDI_SITE_PAGES.DATES;
import static homework.homework_4.pageObjects.CommonPage.MENU_TYPE.HEADER;

public class JDISiteDatesPageTest extends SelenideBase {

    @Test
    public void dragNdropTest() {
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
        datesPage.checkLogCount();
    }

    @Test
    public void dragNdropTest2() {
        // 8. Open Service -> Dates
        commonPage.openPage(HEADER, DATES);

        // 9. Using drag-and-drop set Range sliders.
        // left sliders - the most left position, right slider - the most rigth position
        datesPage.setRangeSlider(0, 100);

        // 10. Using drag-and-drop set Range sliders. Both sliders to left position
        datesPage.setRangeSlider(10, 90);

        // 11. Using drag-and-drop set Range sliders. Both sliders to right position
        datesPage.setRangeSlider(20, 50);
        // 12. Using drag-and-drop set Range sliders.
        datesPage.setRangeSlider(40, 80);
        // 13. Check log
        datesPage.checkLog();
    }

}
