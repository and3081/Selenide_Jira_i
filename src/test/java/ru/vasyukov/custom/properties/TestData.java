package ru.vasyukov.custom.properties;

import org.aeonbits.owner.ConfigFactory;

public class TestData {
    /**
     * static метод для работы с проперти из файла browser.properties и listener.properties
     */
    public static Browser browser = ConfigFactory.create(Browser.class);
    public static Listener listener = ConfigFactory.create(Listener.class);
    public static Application application = ConfigFactory.create(Application.class);
}
