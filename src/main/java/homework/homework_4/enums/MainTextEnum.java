package homework.homework_4.enums;

import lombok.Getter;

@Getter
public enum MainTextEnum {
    PAGE_TITLE("Index Page"),
    MAIN_TITLE("EPAM FRAMEWORK WISHES\u2026"),
    MAIN_TEXT("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
            "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. " +
            "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO " +
            "LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE " +
            "DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU " +
            "FUGIAT NULLA PARIATUR.");

    public String text;

    MainTextEnum(String text) {
        this.text = text;
    }
}
