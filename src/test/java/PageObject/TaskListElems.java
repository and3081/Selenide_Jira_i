package PageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TaskListElems extends BaseElems {
    public static final SelenideElement sideBar = $x("//section[@id='sidebar']");
    public static final SelenideElement buttonTaskList = $x("//section[@id='sidebar']//a[.//text()='Список задач']");

}
