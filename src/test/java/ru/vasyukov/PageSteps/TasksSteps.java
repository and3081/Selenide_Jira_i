package ru.vasyukov.PageSteps;

import io.qameta.allure.Step;
import ru.vasyukov.PageObject.BaseElems;
import ru.vasyukov.PageObject.TasksElems;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;

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
}
