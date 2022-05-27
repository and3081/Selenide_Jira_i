package ru.vasyukov.custom.properties;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:src/test/resources/ru.vasyukov/application.properties"
})
public interface Application extends Config {
    @Key("base.url.jira")
    String baseUrlJira();

    @Key("login")
    String loginJira();

    @Key("password")
    String passwordJira();
}