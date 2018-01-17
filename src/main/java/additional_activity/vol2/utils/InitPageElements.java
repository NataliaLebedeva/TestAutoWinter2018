package additional_activity.vol2.utils;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import additional_activity.vol2.pageObject.Factory;

import java.lang.reflect.Field;
import java.util.Objects;

public class InitPageElements {

    @SneakyThrows
    public static <T> T initPages(WebDriver driver, Class<T> page) {
        T pageInstance = PageFactory.initElements(driver, page);
        for (Field field : page.getFields()) {
            if (!Objects.isNull(field.getAnnotation(Factory.class))) {
                field.set(pageInstance, PageFactory.initElements(driver, field.getType()));
            }
        }
        return pageInstance;
    }
}
