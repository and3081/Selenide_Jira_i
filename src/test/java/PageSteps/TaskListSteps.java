package PageSteps;

import PageObject.SysDashboardElems;
import PageObject.TaskListElems;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;

public class TaskListSteps extends BaseSteps {
    @Step("Проверка head  страницы авторизации")
    public static void assertSideBarPage() {
        TaskListElems.sideBar.shouldBe(visible);
    }

    @Step("Нажатие кнопки сайд-бар Список задач")
    public static void clickTaskListButton() {
        TaskListElems.buttonTaskList.shouldBe(visible, enabled).click();
    }

}
