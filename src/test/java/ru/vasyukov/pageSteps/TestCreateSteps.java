package ru.vasyukov.pageSteps;

import io.qameta.allure.Step;
import ru.vasyukov.custom.Acts;
import ru.vasyukov.custom.Frame;
import ru.vasyukov.pageObjects.TestCreateElem;

import static com.codeborne.selenide.Condition.*;

public class TestCreateSteps extends TestCreateElem {
    @Step("Создание задачи")
    public static void CreateTask(String themeTask, String typeTask, String version,
                                  String description, String environment) {
        assertHeadTestCreate();
        inputTypeTask(typeTask);
        inputFieldTheme(themeTask);
        selectFixVersion(version);
        selectTouchVersion(version);
        inputDescription(description);
        inputEnvironment(environment);
        clickAssignMe();
        clickCreate();
    }

    @Step("Проверка head окна Создание задачи")
    public static void assertHeadTestCreate() {
        headCreateWindow.shouldBe(visible, text("Создание задачи"));
    }

    @Step("Ввод Тип задачи {typeTask}")
    public static void inputTypeTask(String typeTask) {
        fieldTypeTask.shouldBe(visible, enabled).setValue(Acts.clearField + typeTask);
    }

    @Step("Ввод темы задачи {themeTask}")
    public static void inputFieldTheme(String themeTask) {
        fieldTheme.shouldBe(visible, enabled).setValue(themeTask);
    }

    @Step("Ввод в Исправить версии")
    public static void selectFixVersion(String version){
        selectFixVersion.selectOptionContainingText(version);
    }

    @Step("Ввод в Затронуты версии")
    public static void selectTouchVersion(String version){
        selectTouchVersion.selectOptionContainingText(version);
    }

    @Step("Ввод Описание")
    public static void inputDescription(String description){
        Frame.inputToBodyFrame(fieldDescription, description);
    }

    @Step("Ввод Окружение")
    public static void inputEnvironment(String environment){
        Frame.inputToBodyFrame(fieldEnvironment, environment);
    }

    @Step("Нажатие кнопки Назначить меня")
    public static void clickAssignMe() {
        buttonAssignMe.shouldBe(visible, enabled).click();
    }

    @Step("Нажатие кнопки Создать")
    public static void clickCreate() {
        buttonCreate.shouldBe(visible, enabled).click();
    }
}
