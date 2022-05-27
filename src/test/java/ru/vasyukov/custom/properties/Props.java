package ru.vasyukov.custom.properties;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:src/test/resources/ru.vasyukov/props.properties"
})
public interface Props extends Config {
    @Key("webdriver.chrome.local.path")
    String webdriverChromeLocalPath();

    @Key("webdriver.edge.local.path")
    String webdriverEdgeLocalPath();

    @Key("default.timeout.implicit.ms")
    String defaultTimeoutImplicitMs();

    @Key("default.timeout.explicit.ms")
    String defaultTimeoutExplicitMs();

    @Key("type.browser")
    String typeBrowser();

    @Key("dont.close.browser")
    String dontCloseBrowser();

    @Key("headless.mode")
    String headlessMode();

    @Key("remote.url")
    String remoteUrl();
}
