package homework.homework_7_JDI.site.pages;

import homework.homework_7_JDI.entities.UserContactInfo;
import homework.homework_7_JDI.site.forms.ContactForm;
import homework.homework_7_JDI.site.pages.base.LoggedPage;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;


public class ContactPage extends LoggedPage {

    public ContactForm contactForm;

    public void checkResult(UserContactInfo contactInfo) {
        List<String> actual = Arrays.asList(logResultSection.results.getText().split("\n"));
        List<String> expected = contactInfo.toLog();

        Assert.assertEquals(actual.size(), expected.size());
        Assert.assertEquals(actual, expected);

    }


}
