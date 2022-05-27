package ru.vasyukov.tests;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Класс провайдера данных для тестов
 */
public class TestParams {
    protected static Stream<Arguments> providerCreate() {
        return Stream.of(arguments("Test create task AT and3081", "Ошибка", "Version 2.0",
                "Описание дай пять", "Окружение держи пять",
                "СДЕЛАТЬ", "В РАБОТЕ", "ГОТОВО"));
    }
}
