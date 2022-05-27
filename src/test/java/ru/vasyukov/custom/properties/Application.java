package ru.vasyukov.custom.properties;

import org.aeonbits.owner.Config;

/**
 * Интерфейс для работы с проперти из файла application.properties - параметризация тестов
 * usage:  TestData.application.имяМетодаКлюча()
 */
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

    @Key("project.full.name")
    String projectFullName();

    @Key("project.name")
    String projectName();

    @Key("task.name")
    String taskName();
}
