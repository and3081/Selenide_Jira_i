package ru.vasyukov.PageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class TaskListElems extends BaseElems {
    public static final SelenideElement problemCount =
            $x("//div[contains(@class,'backlog-group')]//div[contains(@class,'count') and contains(text(),'проблем')]");
    public static final SelenideElement fieldTaskSearch = $x("//input[@aria-label='Поиск задач']");
    public static final ElementsCollection rowsTaskTitles =
            $$x("//div[contains(@class,'backlog-group')][.//div[contains(text(),'Список задач')]]//div[contains(@class,'row')]//div[@title]");
    public static final SelenideElement goalTaskDetail = $x("//h4[text()='Детали задачи']");
    public static final SelenideElement goalTaskStatus = $x("//span[@id='status-val']");
    public static final SelenideElement goalTaskVersion = $x("//span[@id='versions-field']");

    @Step("Запрос количества задач")
    public static int getTaskCount() {
        return Integer.parseInt(problemCount.shouldBe(visible, enabled).text().trim().split("\\s")[0]);
    }

    @Step("Запрос статуса задачи")
    public static String getGoalTaskStatus() {
        return goalTaskStatus.text().trim();
    }

    @Step("Запрос версии задачи")
    public static String getGoalTaskVersion() {
        return goalTaskVersion.text().trim();
    }
}
