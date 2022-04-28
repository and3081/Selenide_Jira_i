package ru.vasyukov.PageSteps;

import ru.vasyukov.PageObject.BaseElems;
import ru.vasyukov.PageObject.TaskListElems;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;

public class TaskListSteps extends BaseSteps {
    @Step("Проверка сайд-бара страницы")
    public static void assertSideBarPage() {
        BaseElems.sideBar.shouldBe(visible);
    }

    @Step("Нажатие кнопки сайд-бар Список задач")
    public static void clickTaskListButton() {
        TaskListElems.buttonTaskList.shouldBe(visible, enabled).click();
    }

    @Step("Проверка наличия количества задач")
    public static void assertTaskCount() {
        TaskListElems.problemCount.shouldBe(visible);
    }

    @Step("Поиск задачи {name}")
    public static void searchTask(String name) {
        TaskListElems.fieldTaskSearch.shouldBe(visible, enabled).setValue(name).pressEnter();
    }

    @Step("Проверка поиска и клик задачи {name}")
    public static void assertAndClickGoalTask(String name) {
        TaskListElems.rowsTaskTitles
                .shouldBe(size(1))
                .findBy(attribute("title", name))
                .shouldBe(visible, enabled).click();
    }

    @Step("Проверка head деталей задачи")
    public static void assertHeadTaskDetail() {
        TaskListElems.goalTaskDetail.shouldBe(visible);
    }
}
