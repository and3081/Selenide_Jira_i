package ru.vasyukov.custom;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class Frame {
    public static void inputToBodyFrame(SelenideElement elemIframe, String text) {
        selectInFrame(elemIframe);
        $x("//body").shouldBe(visible, enabled).setValue(text);
        selectOutFrame();
    }

    public static void selectInFrame(SelenideElement elemIframe) {
        elemIframe.shouldBe(exist);
        switchTo().frame(elemIframe);
    }

    public static void selectOutFrame() { switchTo().defaultContent(); }

//    public static void inputToBodyFrame(int index, String text) {
//        selectInFrame(index);
//        $x("//body").shouldBe(visible, enabled).setValue(text);
//        selectOutFrame();
//    }
//
//    public static void selectInFrame(int index) {
//        switchTo().frame(index);
//    }
}
