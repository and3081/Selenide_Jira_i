package ru.vasyukov.PageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BaseElems {
    public static final SelenideElement sideBar = $x("//section[@id='sidebar']");
    public static final SelenideElement waitRefresh = $x("//div[@id='page']");
}
