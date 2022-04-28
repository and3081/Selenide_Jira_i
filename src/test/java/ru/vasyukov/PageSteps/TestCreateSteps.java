package ru.vasyukov.PageSteps;

import io.qameta.allure.Step;
import ru.vasyukov.PageObject.TestCreateElem;
import ru.vasyukov.Utils.Acts;
import ru.vasyukov.Utils.Frame;

import static com.codeborne.selenide.Condition.*;

public class TestCreateSteps extends BaseSteps {
    @Step("Проверка head окна Создание задачи")
    public static void assertHeadTestCreate() {
        TestCreateElem.headCreateWindow.shouldBe(exist, visible, text("Создание задачи"));
    }

    @Step("Нажатие combobox Тип задачи, выбор item Ошибка")
    public static void inputTypeTask() {
        TestCreateElem.fieldTypeTask.shouldBe(exist, visible, enabled).click();
        Acts.sendDown();
        Acts.sendEnter();
    }

    @Step("Ввод темы задачи {themeTask}")
    public static void inputFieldTheme(String themeTask) {
        TestCreateElem.fieldTheme.shouldBe(exist, visible, enabled).setValue(themeTask);
    }

    @Step("Ввод в Затронуты версии")
    public static void selectVersion(String version){
        TestCreateElem.selectVersion.selectOptionContainingText(version);
    }

    @Step("Ввод Описание")
    public static void inputDescription(){
        //Frame.inputToBodyFrame(TestCreateElem.fieldNumDescription, "Описание дай пять");
        Frame.inputToBodyFrame(TestCreateElem.fieldDescription, "Описание дай пять");
    }

    @Step("Ввод Окружение")
    public static void inputEnvironment(){
        //Frame.inputToBodyFrame(TestCreateElem.fieldNumEnvironment, "Окружение держи пять");
        Frame.inputToBodyFrame(TestCreateElem.fieldEnvironment, "Окружение держи пять");
    }

    @Step("Нажатие кнопки Назначить меня")
    public static void clickAssignMe() {
        TestCreateElem.buttonAssignMe.shouldBe(exist, visible, enabled).click();
    }

    @Step("Нажатие кнопки Создать")
    public static void clickCreate() {
        TestCreateElem.buttonCreate.shouldBe(exist, visible, enabled).click();
    }
}
