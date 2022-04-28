package ru.vasyukov.PageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TestCreateElem extends BaseElems {
    public static final String baseCreateWindow = "//section[@id[contains(.,'create-issue-dialog')]]";
    public static final SelenideElement headCreateWindow = $x(baseCreateWindow + "//h2");
    public static final SelenideElement fieldTypeTask = $x(baseCreateWindow + "//input[@id='issuetype-field']");
    public static final SelenideElement fieldTheme = $x(baseCreateWindow + "//input[@id='summary']");
    public static final SelenideElement selectVersion = $x(baseCreateWindow + "//select[@id='versions']");
    public static final SelenideElement buttonAssignMe = $x(baseCreateWindow + "//button[text()='Назначить меня']");
    //public static final int fieldNumDescription = 0;
    //public static final int fieldNumEnvironment = 1;
    public static final SelenideElement fieldDescription = $x("//div[@field-id='description']//iframe");
    public static final SelenideElement fieldEnvironment = $x("//div[@field-id='environment']//iframe");
    public static final SelenideElement buttonCreate = $x(baseCreateWindow + "//input[@value='Создать']");
}
