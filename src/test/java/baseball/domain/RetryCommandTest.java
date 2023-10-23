package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RetryCommandTest {

    @Test
    @DisplayName("입력 받은 값이 RetryCommand에 없으면 에러를 발생시킨다.")
    void shouldThrowExceptionWhenInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> RetryCommand.convertTypeCommand("3"));
        assertThrows(IllegalArgumentException.class, () -> RetryCommand.convertTypeCommand(" "));
        assertThrows(IllegalArgumentException.class, () -> RetryCommand.convertTypeCommand("*"));
    }
}