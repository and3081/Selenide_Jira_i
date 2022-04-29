package ru.vasyukov.PageSteps;

import io.qameta.allure.Step;
import ru.vasyukov.PageObject.TestCreateElem;
import ru.vasyukov.Utils.Acts;
import ru.vasyukov.Utils.Frame;

import static com.codeborne.selenide.Condition.*;

public class TestCreateSteps extends TestCreateElem {
    public static void CreateTask(String themeTask, String typeTask, String version) {
        assertHeadTestCreate();
        inputTypeTask(typeTask);
        inputFieldTheme(themeTask);
        selectFixVersion(version);
        selectTouchVersion(version);
        inputDescription();
        inputEnvironment();
        clickAssignMe();
        clickCreate();
    }

    @Step("Проверка head окна Создание задачи")
    public static void assertHeadTestCreate() {
        headCreateWindow.shouldBe(exist, visible, text("Создание задачи"));
    }

    @Step("Ввод Тип задачи {typeTask}")
    public static void inputTypeTask(String typeTask) {
        fieldTypeTask.shouldBe(exist, visible, enabled)
                .setValue(Acts.clearField + typeTask);
    }

    @Step("Ввод темы задачи {themeTask}")
    public static void inputFieldTheme(String themeTask) {
        fieldTheme.shouldBe(exist, visible, enabled).setValue(themeTask);
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
    public static void inputDescription(){
        //Frame.inputToBodyFrame(fieldNumDescription, "Описание дай пять");
        Frame.inputToBodyFrame(fieldDescription, "Описание дай пять");
    }

    @Step("Ввод Окружение")
    public static void inputEnvironment(){
        //Frame.inputToBodyFrame(fieldNumEnvironment, "Окружение держи пять");
        Frame.inputToBodyFrame(fieldEnvironment, "Окружение держи пять");
    }

    @Step("Нажатие кнопки Назначить меня")
    public static void clickAssignMe() {
        buttonAssignMe.shouldBe(exist, visible, enabled).click();
    }

    @Step("Нажатие кнопки Создать")
    public static void clickCreate() {
        buttonCreate.shouldBe(exist, visible, enabled).click();
    }
}
