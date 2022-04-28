import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Класс провайдера данных для тестов
 */
public class TestParams {
    /**
     * Метод-провайдер
     * @return  стрим аргументов (наим.задачи)
     */
    protected static Stream<Arguments> providerJira() {
        return Stream.of(arguments("TestSelenium"));
    }
}
