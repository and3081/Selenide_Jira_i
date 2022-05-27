package ru.vasyukov.pageSteps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import ru.vasyukov.pageObjects.TasksElems;

import static com.codeborne.selenide.Condition.*;

public class TasksSteps extends TasksElems {
    public static void assertTaskCreated(String themeTask) {
        assertHeadAllTasks();
        clickSelectFiltersButton();
        clickItemMyOpenTasks();
        assertHeadMyTask(themeTask);
    }

    @Step("Проверка head Задачи")
    public static void assertHeadOpenTasks() {
        headOpenTasks.shouldBe(visible);
    }

    @Step("Нажатие кнопки Создать задачу")
    public static void clickTaskCreateButton() {
        buttonTaskCreate.shouldBe(visible, enabled).click();
    }

    @Step("Нажатие кнопки Открыть в диалоговом окне")
    public static void clickTaskCreateOpenDialogButton() {
        buttonTaskCreateOpenDialog.shouldBe(visible, enabled).click();
    }

    @Step("Проверка head Все задачи")
    public static void assertHeadAllTasks() {
        headAllTasks.shouldBe(visible);
    }

    @Step("Нажатие кнопки Переключить фильтр")
    public static void clickSelectFiltersButton() {
        buttonSelectFilters.shouldBe(visible, enabled).click();
    }

    @Step("Нажатие пункта Мои открытые задачи")
    public static void clickItemMyOpenTasks() {
        itemMyOpenTasks.shouldBe(visible, enabled).click();
    }

    @Step("Проверка head Моей задачи: {taskName}")
    public static void assertHeadMyTask(String taskName) {
        headMyTask.shouldBe(visible, exactText(taskName));
    }

    @Step("Проверка статуса моей задачи: {status}")
    public static void assertMyTaskStatus(String status) {
        checkEndRefresh();
        Assertions.assertEquals(status, getStatusMyTask(), "Статус не равен " + status);
    }

    @Step("Нажатие кнопки В работе")
    public static void clickStatusInWorkButton() {
        buttonStatusInWork.shouldBe(visible, enabled).click();
    }

    @Step("Нажатие кнопки Бизнес-процесс")
    public static void clickStatusProcessButton() {
        buttonStatusProcess.shouldBe(visible, enabled).click();
    }

    @Step("Нажатие пункта Выполнено")
    public static void clickStatusDoneButton() {
        buttonStatusDone.shouldBe(visible, enabled).click();
    }
}
