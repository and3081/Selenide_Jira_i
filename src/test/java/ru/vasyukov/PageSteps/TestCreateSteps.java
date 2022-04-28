package ru.vasyukov.PageSteps;

import io.qameta.allure.Step;
import ru.vasyukov.PageObject.SysDashboardElems;
import ru.vasyukov.PageObject.TestCreateElem;
import ru.vasyukov.Utils.Acts;

import static com.codeborne.selenide.Condition.*;

public class TestCreateSteps extends BaseSteps {
    @Step("Проверка head окна Создание задачи")
    public static void assertHeadTestCreate() {
        TestCreateElem.headCreateWindow.shouldBe(visible, text("Создание задачи"));
    }

    @Step("Нажатие combobox Тип задачи, выбор item Ошибка")
    public static void inputTypeTask() {
        TestCreateElem.fieldTypeTask.shouldBe(visible, enabled).click();
        Acts.sendDown();
        Acts.sendEnter();
    }

    @Step("Ввод темы задачи {themeTask}")
    public static void inputFieldTheme(String themeTask) {
        TestCreateElem.fieldTheme.shouldBe(visible, enabled).setValue(themeTask);
    }
}
