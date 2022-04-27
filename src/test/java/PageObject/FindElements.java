package PageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class FindElements {
    public static SelenideElement inputPath = $x("//input[@aria-label='Запрос']");
    public static SelenideElement findButton = $x("//span[text()='Найти']/parent::button");
}
