package PageSteps;

import PageObject.SysDashboardElems;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;

public class SysDashboardSteps extends BaseSteps {
    @Step("Проверка head  страницы авторизации")
    public static void assertSysDashboardPage() {
        SysDashboardElems.headSysDashboard.shouldBe(visible);
    }

    @Step("Нажатие dropdown Проекты")
    public static void clickAuthButton() {
        SysDashboardElems.buttonProjects.shouldBe(visible, enabled).click();
    }

    @Step("Нажатие item Test (TEST)")
    public static void clickItemTest() {
        SysDashboardElems.itemTestProject.shouldBe(visible, enabled).click();
    }
}
