package homework.homework_7_JDI.enums;

import lombok.Getter;

@Getter
public enum JDI_PAGES {
    HOME, CONTACT_FORM, METALS_COLORS, SERVICE, SUPPORT(2), DATES(2), COMPLEX_TABLE(2), SIMPLE_TABLE(2), TABLE_WITH_PAGES(2), DIFFERENT_ELEMENTS(2);

    private int level;

    JDI_PAGES() {
        this(1);
    }

    JDI_PAGES(int level) {
        this.level = level;
    }


    @Override
    public String toString() {
        return name().replaceAll("_", " ");
    }
}
