package ru.vasyukov.PageSteps;

import ru.vasyukov.PageObject.SysDashboardElems;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;

public class SysDashboardSteps extends BaseSteps {
    @Step("Проверка dropdown Проекты страницы")
    public static void assertSysDashboardPage() {
        SysDashboardElems.buttonProjects.shouldBe(exist, visible);
    }

    @Step("Нажатие dropdown Проекты")
    public static void clickProjectsButton() {
        SysDashboardElems.buttonProjects.shouldBe(exist, visible, enabled).click();
    }

    @Step("Нажатие item Test (TEST)")
    public static void clickItemTest() {
        SysDashboardElems.itemTestProject.shouldBe(exist, visible, enabled).click();
    }
}
