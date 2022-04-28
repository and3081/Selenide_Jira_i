package ru.vasyukov.PageSteps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import ru.vasyukov.PageObject.BaseElems;
import ru.vasyukov.PageObject.TasksElems;

import static com.codeborne.selenide.Condition.*;

public class TasksSteps extends BaseSteps {
    @Step("Проверка сайд-бара страницы")
    public static void assertSideBarPage() {
        BaseElems.sideBar.shouldBe(exist, visible);
    }

    @Step("Нажатие кнопки сайд-бар Задачи")
    public static void clickTasksButton() {
        TasksElems.buttonTasks.shouldBe(exist, visible, enabled).click();
    }

    @Step("Проверка head Задачи")
    public static void assertHeadOpenTasks() {
        TasksElems.headOpenTasks.shouldBe(exist, visible);
    }

    @Step("Нажатие кнопки Создать задачу")
    public static void clickTaskCreateButton() {
        TasksElems.buttonTaskCreate.shouldBe(exist, visible, enabled).click();
    }

    @Step("Нажатие кнопки Открыть в диалоговом окне")
    public static void clickTaskCreateOpenDialogButton() {
        TasksElems.buttonTaskCreateOpenDialog.shouldBe(exist, visible, enabled).click();
    }

    @Step("Проверка head Все задачи")
    public static void assertHeadAllTasks() {
        TasksElems.headAllTasks.shouldBe(exist, visible);
    }

    @Step("Нажатие кнопки Переключить фильтр")
    public static void clickSelectFiltersButton() {
        TasksElems.buttonSelectFilters.shouldBe(exist, visible, enabled).click();
    }

    @Step("Нажатие пункта Мои открытые задачи")
    public static void clickItemMyOpenTasks() {
        TasksElems.itemMyOpenTasks.shouldBe(exist, visible, enabled).click();
    }

    @Step("Проверка head Моей задачи: {taskName}")
    public static void assertHeadMyTask(String taskName) {
        TasksElems.headMyTask.shouldBe(exist, visible, exactText(taskName));
    }

    @Step("Проверка статуса моей задачи: {stat}")
    public static void assertMyTaskStatus(String stat) {
        Assertions.assertEquals(stat, TasksElems.getStatusMyTask(), "Статус не равен " + stat);
    }

    @Step("Нажатие кнопки В работе")
    public static void clickStatusInWorkButton() {
        TasksElems.buttonStatusInWork.shouldBe(exist, visible, enabled).click();
    }

    @Step("Нажатие кнопки Бизнес-процесс")
    public static void clickStatusProcessButton() {
        TasksElems.buttonStatusProcess.shouldBe(exist, visible, enabled).click();
    }

    @Step("Нажатие пункта Выполнено")
    public static void clickStatusDoneButton() {
        TasksElems.buttonStatusDone.shouldBe(exist, visible, enabled).click();
    }
}
