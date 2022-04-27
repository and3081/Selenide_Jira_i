package PageSteps;

import PageObject.AuthElements;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class AuthSteps extends BaseSteps {
    @Step("Проверка страницы авторизации")
    public static void authAssert(String name) {    // пров.соотв.страницы- заголовки h2...
//        AuthElements.that.shouldBe(visible);
//        AuthElements.that.shouldBe(text(name));
    }

}
