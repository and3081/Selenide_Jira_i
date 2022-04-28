package ru.vasyukov.PageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TasksElems extends BaseElems {
    public static final SelenideElement buttonTasks =
            $x("//section[@id='sidebar']//a[.//text()='Задачи']");
    public static final SelenideElement headOpenTasks = $x("//h1[.//text()='Открытые задачи']");
    public static final SelenideElement buttonTaskCreate =
            $x("//div[contains(.//text(),'Открытые задачи')]//button[.//text()='Создать задачу']");
    public static final SelenideElement buttonTaskCreateOpenDialog =
            $x("//div[contains(.//text(),'Открытые задачи')]//button[.//text()='Открыть в диалоговом окне']");
    public static final SelenideElement headAllTasks = $x("//h1[.//text()='Все задачи']");
    public static final SelenideElement buttonSelectFilters =
            $x("//h1//button[@aria-label='Переключить фильтр']");
    public static final SelenideElement itemMyOpenTasks =
            $x("//div[@id='subnav-opts']//a[text()='Мои открытые задачи']");
    public static final SelenideElement headMyTask = $x("//h1[@id='summary-val']");

}
