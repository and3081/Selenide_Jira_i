package PageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class TaskListElems extends BaseElems {
    public static final SelenideElement sideBar = $x("//section[@id='sidebar']");
    public static final SelenideElement buttonTaskList =
            $x("//section[@id='sidebar']//a[.//text()='Список задач']");
    public static final SelenideElement problemCount =
            $x("//div[contains(@class,'backlog-group')]//div[contains(@class,'count') and contains(text(),'проблем')]");
    public static final SelenideElement fieldTaskSearch = $x("//input[@aria-label='Поиск задач']");

    @Step("Запрос количества задач")
    public static int getProblemCount() {
        return Integer.parseInt(problemCount.shouldBe(visible, enabled).text().trim().split("\\s")[0]);
    }
}
