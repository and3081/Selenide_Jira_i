package ru.vasyukov.pageSteps;

import io.qameta.allure.Step;
import ru.vasyukov.custom.properties.TestData;
import ru.vasyukov.pageObjects.AuthElems;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;

public class AuthSteps extends AuthElems {
    public static void auth() {
        assertAuthPage();
        inputAuthLogin();
        inputAuthPsw();
        clickAuthButton();
        assertButtonProjects();
    }

    @Step("Проверка head блока логина страницы авторизации")
    public static void assertAuthPage() {
        headLogin.shouldBe(visible);
    }

    @Step("Ввод login на странице авторизации")
    public static void inputAuthLogin() {
        fieldLogin.shouldBe(visible, enabled).setValue(TestData.application.loginJira());  //System.getenv()
    }

    @Step("Ввод пароля на странице авторизации")
    public static void inputAuthPsw() {
        fieldPsw.shouldBe(visible, enabled).setValue(TestData.application.passwordJira());
    }

    @Step("Нажатие кнопки Вход")
    public static void clickAuthButton() {
        buttonLogin.shouldBe(visible, enabled).click();
    }

    @Step("Проверка наличия кнопки Проекты")
    public static void assertButtonProjects() {
        buttonProjects.shouldBe(visible);
    }
}
