package ru.vasyukov.tests;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Класс провайдера данных для тестов
 */
public class TestParams {
    protected static Stream<Arguments> providerProject() {
        return Stream.of(arguments( "Test (TEST)", "Test" ));
    }

    protected static Stream<Arguments> providerTask() {
        return Stream.of(arguments( "Test (TEST)", "TestSelenium" ));
    }

    protected static Stream<Arguments> providerCreate() {
        return Stream.of(arguments( "Test (TEST)", "Test" ,
                "Test create task AT and3081", "Ошибка", "Version 2.0",
                "СДЕЛАТЬ", "В РАБОТЕ", "ГОТОВО" ));
    }
}
