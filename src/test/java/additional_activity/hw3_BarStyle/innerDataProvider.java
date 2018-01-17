package additional_activity.hw3_BarStyle;

import org.testng.annotations.DataProvider;

public class innerDataProvider {

    static final String TITLE = "Index Page";
    static final String USERNAME = "Piter Chailovskii";
    static final String MAIN_TITLE = "EPAM FRAMEWORK WISHES\u2026";
    static final String MAIN_TEXT = "LOREM IPSUM DOLOR SIT AMET, " +
            "CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA " +
            "ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP " +
            "EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE " +
            "CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";

    static final String PRACTICES = "To include good practices and ideas from successful EPAM projec";
    static final String CUSTOM = "To be flexible and customizable";
    static final String MULTI = "To be multiplatform";
    static final String BASE = "Already have good base (about 20 internal and" +
            " some external projects), wish to get more\u2026";

    static final String USERLOGIN = "epam";
    static final String USERPASS = "1234";

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

    @DataProvider
    public Object[][] userInfo() {
        return new Object[][]{
                {"epam", "1234"}
        };
    }
}
