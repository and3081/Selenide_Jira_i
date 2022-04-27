package PageObject;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public class BaseSteps extends FindElements {
    public static void clicktoSmth(){
        inputPath.shouldBe(visible, Duration.ofSeconds(60)).click();
        inputPath.setValue("Marvel");
        findButton.click();
    }

}
