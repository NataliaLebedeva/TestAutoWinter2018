package homework.homework_7_JDI.enums;

import lombok.Getter;

import java.util.Objects;

@Getter
public enum JDI_PAGES {
    HOME, CONTACT_FORM, METALS_COLORS("Metals & Colors"), SERVICE, SUPPORT(2), DATES(2), COMPLEX_TABLE(2), SIMPLE_TABLE(2), TABLE_WITH_PAGES(2), DIFFERENT_ELEMENTS(2);

    private int level;
    private String name;

    JDI_PAGES() {
        this(1);
    }

    JDI_PAGES(String name) {
        this.name = name;
    }

    JDI_PAGES(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        if (!Objects.isNull(name))
            return name;
        else
            return name().replaceAll("_", " ");
    }
}
