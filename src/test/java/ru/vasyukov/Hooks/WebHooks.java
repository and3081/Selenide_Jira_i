package ru.vasyukov.Hooks;

import ru.vasyukov.Properties.TestData;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class WebHooks {
    @BeforeAll
    public static void setDriverProps() {
        String webDriverLocation = TestData.props.webdriverLocalPath();
        if (TestData.props.remoutUrl() != null)
            Configuration.remote = TestData.props.remoutUrl();
        if (webDriverLocation != null) {
            System.setProperty("webdriver.chrome.driver", webDriverLocation);
            System.setProperty("selenide.browser", "Chrome");
        } else
            Configuration.browser = "chrome";
        Configuration.timeout = 5000;
        Configuration.startMaximized = true;
        Configuration.holdBrowserOpen = true;
        //Configuration.headless = true;

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
        open(TestData.props.baseUrl());
    }

    @AfterEach
    public void driverClose() {
        WebDriverRunner.closeWebDriver();
    }
}
