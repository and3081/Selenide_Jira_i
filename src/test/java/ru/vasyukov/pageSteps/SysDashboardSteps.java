package ru.vasyukov.pageSteps;

import io.qameta.allure.Step;
import ru.vasyukov.pageObjects.SysDashboardElems;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;

public class SysDashboardSteps extends SysDashboardElems {
    @Step("Вход в проект")
    public static void enteringProject(String projectFullName, String projectName) {
        clickProjectsButton();
        clickItemTest(projectFullName);
        clickSideBarTasksButton();
        assertLinkProjects(projectName);
    }

    @Step("Нажатие dropdown Проекты")
    public static void clickProjectsButton() {
        buttonProjects.shouldBe(visible, enabled).click();
    }

    @Step("Нажатие item {projectFullName}")
    public static void clickItemTest(String projectFullName) {
        getItemProject(projectFullName).shouldBe(visible, enabled).click();
    }

    @Step("Проверка наличия линка {projectName}")
    public static void assertLinkProjects(String projectName) {
        getLinkProject(projectName).shouldBe(visible);
    }
}
