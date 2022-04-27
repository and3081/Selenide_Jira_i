import Hooks.WebHooks;
import org.junit.jupiter.api.Test;

import static PageSteps.BaseSteps.clicktoSmth;
import static com.codeborne.selenide.Selenide.*;

public class Tests extends WebHooks {
    @Test
    public void Test_1(){
        clicktoSmth();
    }
}
