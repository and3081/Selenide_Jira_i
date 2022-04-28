package ru.vasyukov.Utils;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Frame {
    public static final WebDriver driver = getWebDriver();

    public static void inputToBodyFrame(SelenideElement elemIframe, String text) {
        selectInFrame(elemIframe);
        $x("//body").shouldBe(exist, visible, enabled).setValue(text);
        selectOutFrame();
    }

    public static void selectInFrame(SelenideElement elemIframe) {
        elemIframe.shouldBe(exist);
        driver.switchTo().frame(elemIframe);
    }

    public static void selectOutFrame() { driver.switchTo().defaultContent(); }
}
