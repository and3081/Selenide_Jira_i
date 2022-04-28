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
}
