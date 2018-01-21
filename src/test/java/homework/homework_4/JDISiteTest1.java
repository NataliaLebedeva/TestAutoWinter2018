package homework.homework_4;

import org.testng.annotations.*;

public class JDISiteTest1 extends SelenideBase {

    @Test
    public void indexPageTest() {
        indexPage.checkPageTitle();
        indexPage.checkBenefitsTextsStream();
        indexPage.checkBenefitsIcon();
        indexPage.checkMainText();
    }


}
