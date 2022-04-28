package ru.vasyukov.PageSteps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import ru.vasyukov.PageObject.BaseElems;
import ru.vasyukov.PageObject.TasksElems;

import static com.codeborne.selenide.Condition.*;

public class TasksSteps extends BaseSteps {
    @Step("Проверка сайд-бара страницы")
    public static void assertSideBarPage() {
        BaseElems.sideBar.shouldBe(visible);
    }

    @Step("Нажатие кнопки сайд-бар Задачи")
    public static void clickTasksButton() {
        TasksElems.buttonTasks.shouldBe(visible, enabled).click();
    }

    @Step("Проверка head Задачи")
    public static void assertHeadOpenTasks() {
        TasksElems.headOpenTasks.shouldBe(visible);
    }

    @Step("Нажатие кнопки Создать задачу")
    public static void clickTaskCreateButton() {
        TasksElems.buttonTaskCreate.shouldBe(visible, enabled).click();
    }

    @Step("Нажатие кнопки Открыть в диалоговом окне")
    public static void clickTaskCreateOpenDialogButton() {
        TasksElems.buttonTaskCreateOpenDialog.shouldBe(visible, enabled).click();
    }

    @Step("Проверка head Все задачи")
    public static void assertHeadAllTasks() {
        TasksElems.headAllTasks.shouldBe(visible);
    }

    @Step("Нажатие кнопки Переключить фильтр")
    public static void clickSelectFiltersButton() {
        TasksElems.buttonSelectFilters.shouldBe(visible, enabled).click();
    }

    @Step("Нажатие пункта Мои открытые задачи")
    public static void clickItemMyOpenTasks() {
        TasksElems.itemMyOpenTasks.shouldBe(visible, enabled).click();
    }

    @Step("Проверка head Моей задачи: {taskName}")
    public static void assertHeadMyTask(String taskName) {
        TasksElems.headMyTask.shouldBe(visible, exactText(taskName));
    }

    @Step("Проверка статуса моей задачи: {stat}")
    public static void assertMyTaskStatus(String stat) {
        Assertions.assertEquals(stat, TasksElems.getStatusMyTask(), "Статус не равен " + stat);
    }

    @Step("Нажатие кнопки В работе")
    public static void clickStatusInWorkButton() {
        TasksElems.buttonStatusInWork.shouldBe(visible, enabled).click();
    }
}
