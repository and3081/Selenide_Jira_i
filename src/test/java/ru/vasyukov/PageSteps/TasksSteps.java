package ru.vasyukov.PageSteps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import ru.vasyukov.PageObject.BaseElems;
import ru.vasyukov.PageObject.TasksElems;

import static com.codeborne.selenide.Condition.*;

public class TasksSteps extends TasksElems {
    @Step("Проверка сайд-бара страницы")
    public static void assertSideBarPage() {
        BaseElems.sideBar.shouldBe(exist, visible);
    }

    @Step("Нажатие кнопки сайд-бар Задачи")
    public static void clickTasksButton() {
        buttonTasks.shouldBe(exist, visible, enabled).click();
    }

    @Step("Проверка head Задачи")
    public static void assertHeadOpenTasks() {
        headOpenTasks.shouldBe(exist, visible);
    }

    @Step("Нажатие кнопки Создать задачу")
    public static void clickTaskCreateButton() {
        buttonTaskCreate.shouldBe(exist, visible, enabled).click();
    }

    @Step("Нажатие кнопки Открыть в диалоговом окне")
    public static void clickTaskCreateOpenDialogButton() {
        buttonTaskCreateOpenDialog.shouldBe(exist, visible, enabled).click();
    }

    @Step("Проверка head Все задачи")
    public static void assertHeadAllTasks() {
        headAllTasks.shouldBe(exist, visible);
    }

    @Step("Нажатие кнопки Переключить фильтр")
    public static void clickSelectFiltersButton() {
        buttonSelectFilters.shouldBe(exist, visible, enabled).click();
    }

    @Step("Нажатие пункта Мои открытые задачи")
    public static void clickItemMyOpenTasks() {
        itemMyOpenTasks.shouldBe(exist, visible, enabled).click();
    }

    @Step("Проверка head Моей задачи: {taskName}")
    public static void assertHeadMyTask(String taskName) {
        headMyTask.shouldBe(exist, visible, exactText(taskName));
    }

    @Step("Проверка статуса моей задачи: {stat}")
    public static void assertMyTaskStatus(String stat) {
        Assertions.assertEquals(stat, getStatusMyTask(), "Статус не равен " + stat);
    }

    @Step("Нажатие кнопки В работе")
    public static void clickStatusInWorkButton() {
        buttonStatusInWork.shouldBe(exist, visible, enabled).click();
    }

    @Step("Нажатие кнопки Бизнес-процесс")
    public static void clickStatusProcessButton() {
        buttonStatusProcess.shouldBe(exist, visible, enabled).click();
    }

    @Step("Нажатие пункта Выполнено")
    public static void clickStatusDoneButton() {
        buttonStatusDone.shouldBe(exist, visible, enabled).click();
    }
}
