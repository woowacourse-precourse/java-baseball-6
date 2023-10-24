package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class RetryCommandTest {

    @ParameterizedTest
    @ValueSource(strings = {"3", " ", "*", "a"})
    @DisplayName("입력 받은 값이 RetryCommand에 없으면 에러를 발생시킨다.")
    void shouldThrowExceptionWhenInvalidInput(String input) {
        assertThrows(IllegalArgumentException.class, () -> RetryCommand.convertTypeCommand(input));
    }
}