package PageSteps;

import PageObject.TaskListElems;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;

public class TaskListSteps extends BaseSteps {
    @Step("Проверка сайд-бара страницы")
    public static void assertSideBarPage() {
        TaskListElems.sideBar.shouldBe(visible);
    }

    @Step("Нажатие кнопки сайд-бар Список задач")
    public static void clickTaskListButton() {
        TaskListElems.buttonTaskList.shouldBe(visible, enabled).click();
    }

    @Step("Проверка количества задач")
    public static void assertTaskCount() {
        TaskListElems.problemCount.shouldBe(visible);
    }

    @Step("Поиск задачи {name}")
    public static void searchTask(String name) {
        TaskListElems.fieldTaskSearch.shouldBe(visible, enabled).setValue(name).pressEnter();
    }
}
