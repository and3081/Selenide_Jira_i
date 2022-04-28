package ru.vasyukov.PageSteps;

import ru.vasyukov.PageObject.AuthElems;
import ru.vasyukov.Properties.TestData;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;

public class AuthSteps extends BaseSteps {
    @Step("Проверка head блока логина страницы авторизации")
    public static void assertAuthPage() {
        AuthElems.headLogin.shouldBe(exist, visible);
    }

    @Step("Ввод login на странице авторизации")
    public static void inputAuthLogin() {
        AuthElems.fieldLogin.shouldBe(exist, visible, enabled).setValue(System.getenv(TestData.props.loginJira()));
    }

    @Step("Ввод пароля на странице авторизации")
    public static void inputAuthPsw() {
        AuthElems.fieldPsw.shouldBe(exist, visible, enabled).setValue(System.getenv(TestData.props.passwordJira()));
    }

    @Step("Нажатие кнопки Вход")
    public static void clickAuthButton() {
        AuthElems.buttonLogin.shouldBe(exist, visible, enabled).click();
    }
}
