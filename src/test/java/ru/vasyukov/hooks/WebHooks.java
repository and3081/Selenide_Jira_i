package ru.vasyukov.hooks;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.WebDriverListener;
import ru.vasyukov.custom.Listeners;
import ru.vasyukov.custom.properties.PropertyData;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.*;

/**
 * Класс хуков для настройки web драйвера по проперти browser.properties:
 *  - локального
 *  - удаленного (Selenide)
 *  - ремоут (Selenoid)
 */
public class WebHooks {
    /**
     * Объект Listeners в зависимости от настройки в проперти или null
     */
    private static final WebDriverListener listener = Listeners.getListener();

    // Настройка опций браузера и листенера первый раз
    static {
        Configuration.timeout = Long.parseLong(PropertyData.browser.defaultTimeoutImplicitMs());
        if (listener != null) addListener(listener);
        if (PropertyData.browser.headlessMode() != null) Configuration.headless = true;
        if (PropertyData.browser.dontCloseBrowser() != null) Configuration.holdBrowserOpen = true;

        if (PropertyData.browser.remoteUrl() != null) {
            Configuration.remote = PropertyData.browser.remoteUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "chrome");
            capabilities.setCapability("browserVersion", "101.0");
            Map<String, Object> map = new HashMap<>();
            map.put("enableVNC", true);
            map.put("enableVideo", true);
            capabilities.setCapability("selenoid:options", map);
            Configuration.browserCapabilities = capabilities;
        } else {
            if ((PropertyData.browser.typeBrowser() == null || PropertyData.browser.typeBrowser().equals("chrome")) &&
                    PropertyData.browser.webdriverChromeLocalPath() != null) {
                System.setProperty("webdriver.chrome.driver", PropertyData.browser.webdriverChromeLocalPath());
                WebDriver driver = new ChromeDriver();
                setWebDriver(driver);
            } else if (PropertyData.browser.typeBrowser() != null)
                if (PropertyData.browser.typeBrowser().equals("edge")) {
                    System.setProperty("webdriver.edge.driver", PropertyData.browser.webdriverEdgeLocalPath());
                    WebDriver driver = new EdgeDriver();
                    setWebDriver(driver);
                } else Configuration.browser = PropertyData.browser.typeBrowser();
            else Configuration.browser = "chrome";
        }
    }

    /**
     * Открытие базового url и максимизация окна перед каждым тестом
     */
    @BeforeEach
    public void openBrowser() {
        open(PropertyData.application.baseUrlJira());
        getWebDriver().manage().window().maximize();
    }

    /**
     * Закрытие web драйвера после каждого теста
     */
    @AfterEach
    public void close() {
        //closeWindow();  // holdBrowserOpen с этим не работает
        closeWebDriver();
    }
}
