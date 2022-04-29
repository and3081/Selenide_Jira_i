package ru.vasyukov.PageSteps;

import io.qameta.allure.Step;
import ru.vasyukov.PageObject.TestCreateElem;
import ru.vasyukov.Utils.Acts;
import ru.vasyukov.Utils.Frame;

import static com.codeborne.selenide.Condition.*;

public class TestCreateSteps extends TestCreateElem {
    @Step("Проверка head окна Создание задачи")
    public static void assertHeadTestCreate() {
        headCreateWindow.shouldBe(exist, visible, text("Создание задачи"));
    }

    @Step("Нажатие combobox Тип задачи, выбор item Ошибка")
    public static void inputTypeTask() {
        fieldTypeTask.shouldBe(exist, visible, enabled).click();
        Acts.sendDown();
        Acts.sendEnter();
    }

    @Step("Ввод темы задачи {themeTask}")
    public static void inputFieldTheme(String themeTask) {
        fieldTheme.shouldBe(exist, visible, enabled).setValue(themeTask);
    }

    @Step("Ввод в Затронуты версии")
    public static void selectVersion(String version){
        selectVersion.selectOptionContainingText(version);
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
