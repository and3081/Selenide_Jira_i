package Properties;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:props.properties"
})
public interface Props extends Config {
    @Key("base.url")
    String baseUrl();
    @Key("login")
    String loginJira();
    @Key("password")
    String passwordJira();
    @Key("webdriver.local.path")
    String webdriverLocalPath();
}
