package homework.homework_7_JDI.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MetalsColorsFormData {
    public static final MetalsColorsFormData DEFAULT = new MetalsColorsFormData(
            Arrays.asList(3, 8),
            Arrays.asList("Water", "Fire"),
            "Red",
            "Selen",
            Arrays.asList("Cucumber", "Tomato")
    );

    private List<Integer> summary;
    private List<String> elements;
    private String color;
    private String metal;
    private List<String> vegetables;

    public List<String> toLog() {
        return new LinkedList<String>() {{
            add(String.format("Summary: %s", summary.stream().mapToInt(Integer::new).sum()));
            add(String.format("Elements: %s", elements.stream().collect(Collectors.joining(", "))));
            add(String.format("Color: %s", color));
            add(String.format("Metal: %s", metal));
            add(String.format("Vegetables: %s", vegetables.stream().collect(Collectors.joining(", "))));
        }};
    }
}
