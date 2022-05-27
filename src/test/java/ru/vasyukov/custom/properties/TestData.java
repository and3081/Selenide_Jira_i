package ru.vasyukov.custom.properties;

import org.aeonbits.owner.ConfigFactory;

public class TestData {
    /**
     * static метод для работы с проперти из файла props.properties и listener.properties
     */
    public static Props props = ConfigFactory.create(Props.class);
    public static Listener listener = ConfigFactory.create(Listener.class);
    public static Application application = ConfigFactory.create(Application.class);
}
