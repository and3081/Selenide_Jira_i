package ru.vasyukov.pageSteps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import ru.vasyukov.pageObjects.TaskListElems;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;

/**
 * Класс шагов входа в задачу и проверки количества задач
 */
public class TaskListSteps extends TaskListElems {
    @Step("Вход в задачу")
    public static void enteringTask(String projectFullName, String taskName) {
        SysDashboardSteps.clickProjectsButton();
        SysDashboardSteps.clickItemTest(projectFullName);
        clickSideBarTaskListButton();
        TaskListSteps.searchTask(taskName);
        TaskListSteps.assertAndClickGoalTask(taskName);
    }

    @Step("Проверка наличия количества задач")
    public static void assertTaskCount() {
        problemCount.shouldBe(visible);
        Assertions.assertTrue(stepCount(getTaskCount()) > 0,
                "Количество задач не найдено");
    }

    @Step("Количество задач '{count}'")
    public static int stepCount(int count) {
        return count;
    }

    @Step("Поиск задачи {name}")
    public static void searchTask(String name) {
        fieldTaskSearch.shouldBe(visible, enabled).setValue(name).pressEnter();
    }

    @Step("Проверка поиска и клик задачи {name}")
    public static void assertAndClickGoalTask(String name) {
        rowsTaskTitles.shouldBe(size(1))
                .findBy(attribute("title", name))
                .shouldBe(visible, enabled).click();
    }

    @Step("Проверка head деталей задачи")
    public static void assertHeadTaskDetail() {
        goalTaskDetail.shouldBe(visible);
        stepDetail(getGoalTaskStatus(), getGoalTaskVersion());
    }

    @Step("Статус задачи '{status}', версия задачи '{version}'")
    public static void stepDetail(String status, String version) {
    }
}
