package ru.vasyukov.Utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Acts {
    public static final WebDriver driver = getWebDriver();
    public static final Actions acts = new Actions(driver);

    public static void sendDown() { acts.sendKeys(Keys.DOWN).perform(); }

    public static void sendEnter() {
        acts.sendKeys(Keys.ENTER).perform();
    }
}
