package homework.homework_4.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homework.homework_4.enums.BenefitsTextEnum;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.title;
import static homework.homework_4.enums.MainTextEnum.*;

public class HomePage {

    @FindBy(css = ".benefit-icon")
    private ElementsCollection benefitIcon;

    @FindBy(css = ".benefit-txt")
    private ElementsCollection benefitTxt;

    @FindBy(css = ".main-txt")
    private SelenideElement mainText;

    @FindBy(css = ".main-title")
    private SelenideElement mainTitle;

    public void checkPageTitle() {
        Assert.assertTrue(title().equals(PAGE_TITLE.getText()));
    }

    public void checkBenefitsIcon() {
        benefitIcon.shouldHave(size(4));
        for (SelenideElement icon : benefitIcon) {
            icon.shouldBe(visible);
        }
    }

    public void checkBenefitsTextsSelenide() {
        BenefitsTextEnum[] values = BenefitsTextEnum.values();
        benefitTxt.shouldHave(size(values.length));
        for (int i = 0; i < values.length; i++) {
            String s = values[i].getText();
            // should be replaced by simple assert, just 4 example
            benefitTxt.get(i).should(new Condition("testIgnore\\n") {
                @Override
                public boolean apply(WebElement element) {
                    return element.getText().replaceAll("\n", " ").equals(s);
                }
            });
        }
    }

    public void checkBenefitsTextsStream() {
        Function<String, String> replace = (s) -> s.replaceAll("\n", " ").toLowerCase().trim();

        List<String> expected = Arrays.stream(BenefitsTextEnum.values())
                .map(BenefitsTextEnum::getText)
                .map(replace).collect(Collectors.toList());
        List<String> actual = benefitTxt.stream()
                .map(SelenideElement::getText)
                .map(replace).collect(Collectors.toList());

        Assert.assertEquals(actual, expected);
    }

    public void checkMainText() {
        mainTitle.shouldHave(text(MAIN_TITLE.getText()));
        mainText.shouldHave(text(MAIN_TEXT.getText()));
    }
}
