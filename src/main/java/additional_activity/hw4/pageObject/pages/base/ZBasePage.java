package additional_activity.hw4.pageObject.pages.base;

import additional_activity.hw4.utils.factory.ZSection;
import additional_activity.hw4.pageObject.sections.ZLoginFormSection;
import additional_activity.hw4.pageObject.sections.ZMainMenuSection;

public class ZBasePage {
    @ZSection
    public ZMainMenuSection mainMenu;

    @ZSection
    public ZLoginFormSection loginForm;
}
