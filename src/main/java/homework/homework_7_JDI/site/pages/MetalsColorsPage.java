package homework.homework_7_JDI.site.pages;

import homework.homework_7_JDI.entities.MetalsColorsFormData;
import homework.homework_7_JDI.site.forms.MetalsColorsForm;
import homework.homework_7_JDI.site.pages.base.LoggedPage;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class MetalsColorsPage extends LoggedPage {

    public MetalsColorsForm metalsColorsForm;

    public void checkResult(MetalsColorsFormData mc) {
        List<String> actual = Arrays.asList(logResultSection.results.getText().split("\n"));
        List<String> expected = mc.toLog();

        Assert.assertEquals(actual.size(), expected.size());
        for (String e : expected) {
            Assert.assertTrue(actual.contains(e));
        }
    }
}
