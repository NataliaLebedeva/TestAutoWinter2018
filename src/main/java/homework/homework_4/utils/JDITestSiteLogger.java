package homework.homework_4.utils;

import com.google.common.collect.Lists;
import homework.homework_4.enums.Colors;
import homework.homework_4.enums.Metals;
import homework.homework_4.enums.NatureElements;
import lombok.val;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;

import static java.lang.String.format;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;
import static org.testng.Assert.assertEquals;

public final class JDITestSiteLogger {
    private static List<String> DATA = new ArrayList<>();

    private static final String CONDITION = "%s: condition changed to %s";
    private static final String METAL_CHANGED = "metal: value changed to %s";
    private static final String COLOR_CHANGED = "Colors: value changed to %s";

    private static HashMap<Class, BiFunction<String, String, String>> map = new HashMap<Class, BiFunction<String, String, String>>() {{
        put(NatureElements.class, (name, status) -> format(CONDITION, name, status));
        put(Colors.class, (name, status) -> format(COLOR_CHANGED, name));
        put(Metals.class, (name, status) -> format(METAL_CHANGED, name));
    }};

    public static void Add(Object c) {
        DATA.add(map.get(c.getClass()).apply(c.toString(), null));
    }

    public static void Add(Object o, Boolean status) {
        DATA.add(map.get(o.getClass()).apply(o.toString(), status.toString()));
    }

    public static String GetLogAsString() {
        return Lists
                .reverse(DATA).stream()
                .collect(joining("|"))
                .toLowerCase()
                .replaceAll(" ", "");
    }

    private JDITestSiteLogger() {
    }

    public static void Check(String actual) {
        val expected = GetLogAsString();

        val actualLog = stream(actual.split("\n"))
                .map(s -> s.replaceAll("(\\d{2}:\\d{2}:\\d{2})", ""))
                .collect(joining("|"))
                .toLowerCase()
                .replaceAll(" ", "");

        assertEquals(expected, actualLog, format("ACTUAL:\n%s\nEXPECTED:\n%s", actual, DATA.stream().collect(joining("\n"))));
    }
}
