package ru.vasyukov.pageObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AuthElems extends BaseElems {
    public static final SelenideElement headLogin = $x("//h3[text()='Вход в систему']");
    public static final SelenideElement fieldLogin = $x("//input[@id='login-form-username']");
    public static final SelenideElement fieldPsw = $x("//input[@id='login-form-password']");
    public static final SelenideElement buttonLogin = $x("//input[@value='Войти']");
}
