package ru.vasyukov.pageObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SysDashboardElems extends BaseElems {
    public static final String itemTestProject1 = "//div[@id='project_current']//a[text()='";
    public static final String itemTestProject2 = "']";
    public static final String linkCurrentProject1 = "//li//a[text()='";
    public static final String linkCurrentProject2 = "']";

    public static SelenideElement getItemProject(String projectFullName) {
        return $x(itemTestProject1 + projectFullName + itemTestProject2);
    }

    public static SelenideElement getLinkProject(String projectName) {
        return $x(linkCurrentProject1 + projectName + linkCurrentProject2);
    }
}
