package ru.vasyukov.PageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class TestCreateElem extends BaseElems {
    public static final SelenideElement headCreateWindow = $x("//section[@id[contains(.,'create-issue-dialog')]]//h2");
    public static final String baseCreateForm = "//form[@id='dialog-form']";
    public static final SelenideElement fieldTypeTask = $x(baseCreateForm + "//input[@id='issuetype-field']");
    public static final SelenideElement fieldTheme = $x(baseCreateForm + "//input[@id='summary']");
//    public static final SelenideElement field = $x(baseCreateForm + "");
//    public static final SelenideElement field = $x(baseCreateForm + "");
//    public static final SelenideElement field = $x(baseCreateForm + "");
//    public static final SelenideElement field = $x(baseCreateForm + "");
//    public static final SelenideElement field = $x(baseCreateForm + "");
//    public static final SelenideElement field = $x(baseCreateForm + "");
}
