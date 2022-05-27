package ru.vasyukov.pageSteps;

import io.qameta.allure.Step;
import ru.vasyukov.pageObjects.TaskListElems;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;

public class TaskListSteps extends TaskListElems {
    @Step("Проверка наличия количества задач")
    public static void assertTaskCount() {
        problemCount.shouldBe(exist, visible);
        stepCount(getTaskCount());
    }

    @Step("Количество задач '{count}'")
    public static void stepCount(int count) {
    }

    @Step("Поиск задачи {name}")
    public static void searchTask(String name) {
        fieldTaskSearch.shouldBe(exist, visible, enabled).setValue(name).pressEnter();
    }

    @Step("Проверка поиска и клик задачи {name}")
    public static void assertAndClickGoalTask(String name) {
        rowsTaskTitles.shouldBe(size(1))
                .findBy(attribute("title", name))
                .shouldBe(exist, visible, enabled).click();
    }

    @Step("Проверка head деталей задачи")
    public static void assertHeadTaskDetail() {
        goalTaskDetail.shouldBe(exist, visible);
        stepDetail(getGoalTaskStatus(), getGoalTaskVersion());
    }

    @Step("Статус задачи '{status}', версия задачи '{version}'")
    public static void stepDetail(String status, String version) {
    }
}
