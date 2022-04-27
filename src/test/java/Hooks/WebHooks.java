package Hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.open;

public class WebHooks {
    @BeforeAll
    public static void setDriverProps() {
        Configuration.timeout = 6000;
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.holdBrowserOpen = true;

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//        Configuration.browserCapabilities = capabilities;
//        System.setProperty("webdriver.chrome.driver", System.getenv("drivers/"));
//        WebDriver driver;
//        driver = new ChromeDriver(options);
//        setWebDriver(driver);
    }

    @BeforeEach
    public void startOpen() {
        //open("Utils.Configuration.get...");
    }

    @AfterEach
    public void driverClose() {
        //WebDriverRunner.closeWebDriver();
    }
}
