package ru.vasyukov.PageSteps;

import com.codeborne.selenide.Condition;
import ru.vasyukov.PageObject.BaseElems;

public class BaseSteps {
    public static void checkEndRefresh() {
        BaseElems.waitRefresh.shouldNotHave(Condition.attribute("aria-hidden"));
    }
}
