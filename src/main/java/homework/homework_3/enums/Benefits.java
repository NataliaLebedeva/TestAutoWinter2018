package homework.homework_3.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public enum Benefits {
    TEXT_1("To include good practices and ideas from successful EPAM projec"),
    TEXT_2("To be flexible and customizable"),
    TEXT_3("To be multiplatform"),
    TEXT_4("Already have good base (about 20 internal and some external projects), wish to get more\u2026");

    public String text;

    Benefits(String text) {
        this.text = text;
    }

    public static List<String> AsList() {
        return Arrays.stream(values()).map(Benefits::getText).collect(Collectors.toList());
    }
}
