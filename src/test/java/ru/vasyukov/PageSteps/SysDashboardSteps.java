package ru.vasyukov.PageSteps;

import ru.vasyukov.PageObject.SysDashboardElems;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;

public class SysDashboardSteps extends SysDashboardElems {
    @Step("Проверка dropdown Проекты страницы")
    public static void assertSysDashboardPage() {
        buttonProjects.shouldBe(exist, visible);
    }

    @Step("Нажатие dropdown Проекты")
    public static void clickProjectsButton() {
        buttonProjects.shouldBe(exist, visible, enabled).click();
    }

    @Step("Нажатие item Test (TEST)")
    public static void clickItemTest() {
        itemTestProject.shouldBe(exist, visible, enabled).click();
    }
}
