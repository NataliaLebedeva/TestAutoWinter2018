package additional_activity.hw4.utils;

import additional_activity.hw4.utils.factory.ZPage;
import additional_activity.hw4.utils.factory.ZSection;
import com.codeborne.selenide.Selenide;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class ZUtils {

    private ZUtils() {
    }

    @SneakyThrows
    public static <T> void init(Class<T> t) {
        List<Field> pages = Arrays.stream(t.getFields())
                .filter(f -> !Objects.isNull(f.getAnnotation(ZPage.class)))
                .filter(f -> Modifier.isStatic(f.getModifiers()))
                .collect(Collectors.toList());

        for (Field f : pages) {
            Object page = Selenide.page(f.getType());

            List<Field> sections = Arrays.stream(f.getType().getFields())
                    .filter(s -> !Objects.isNull(s.getAnnotation(ZSection.class)))
                    .filter(s -> !Modifier.isStatic(s.getModifiers()))
                    .collect(Collectors.toList());

            for (Field s : sections) {
                s.set(page, Selenide.page(s.getType()));
            }

            f.set(null, page);
        }
    }
}
