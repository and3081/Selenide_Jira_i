package PageSteps;

import PageObject.AuthElems;
import Properties.TestData;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;

public class AuthSteps extends BaseSteps {
    @Step("Проверка head блока логина страницы авторизации")
    public static void assertAuthPage() {
        AuthElems.headLogin.shouldBe(visible);
    }

    @Step("Ввод login на странице авторизации")
    public static void inputAuthLogin() {
        AuthElems.fieldLogin.shouldBe(visible, enabled).setValue(TestData.props.loginJira());
    }

    @Step("Ввод пароля на странице авторизации")
    public static void inputAuthPsw() {
        AuthElems.fieldPsw.shouldBe(visible, enabled).setValue(TestData.props.passwordJira());
    }

    @Step("Нажатие кнопки Вход")
    public static void clickAuthButton() {
        AuthElems.buttonLogin.shouldBe(visible, enabled).click();
    }
}
