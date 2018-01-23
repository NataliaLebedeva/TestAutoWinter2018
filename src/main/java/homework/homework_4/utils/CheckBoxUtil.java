package homework.homework_4.utils;

import com.codeborne.selenide.SelenideElement;

import java.util.Objects;

public final class CheckBoxUtil {
    private CheckBoxUtil() {
    }

    public static void check(SelenideElement element) {
        if (!isChecked(element))
            element.click();
    }

    public static void unCheck(SelenideElement element) {
        if (isChecked(element))
            element.click();
    }

    public static boolean isChecked(SelenideElement element) {
        return !Objects.isNull(element.getAttribute("checked"));
    }
}
