package ru.vasyukov.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class BaseElems {
    public static final SelenideElement buttonProjects = $x("//nav//a[text()='Проекты']");
    public static final SelenideElement sideBar = $x("//section[@id='sidebar']");
    public static final SelenideElement buttonSideBarTaskList =
            $x("//section[@id='sidebar']//a[.//text()='Список задач']");
    public static final SelenideElement buttonSideBarTasks =
            $x("//section[@id='sidebar']//a[.//text()='Задачи']");
    public static final SelenideElement waitRefresh = $x("//div[@id='page']");

    @Step("Нажатие кнопки сайд-бар Список задач")
    public static void clickSideBarTaskListButton() {
        sideBar.shouldBe(visible);
        buttonSideBarTaskList.shouldBe(visible, enabled).click();
    }

    @Step("Нажатие кнопки сайд-бар Задачи")
    public static void clickSideBarTasksButton() {
        sideBar.shouldBe(visible);
        buttonSideBarTasks.shouldBe(visible, enabled).click();
    }

    public static void checkEndRefresh() {
        waitRefresh.shouldNotHave(Condition.attribute("aria-hidden"));
    }
}
