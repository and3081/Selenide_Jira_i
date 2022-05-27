package ru.vasyukov.custom.properties;

import org.aeonbits.owner.Config;

/**
 * Интерфейс для работы с проперти из файла listener.properties - настройки листенера скриншотов для Allure
 * usage:  TestData.listener.имяМетодаКлюча()
 * Описание в файле listener.properties
 */
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:src/test/resources/ru.vasyukov/listener.properties"
})
public interface Listener extends Config {
    @Key("listener.type")
    String listenerType();

    @Key("listener.around.method")
    String listenerAroundMethod();

    @Key("listener.method.list")
    String listenerMethodList();

    @Key("listener.mode.elements")
    String listenerModeElements();
}
