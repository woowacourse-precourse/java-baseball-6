package baseball.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    @DisplayName("유효하지 않은 값을 입력하는 경우")
    void validateCheckRestartGameInput() {
        String input = "0";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                InputValidator.validateCheckRestartGameInput(input);
        });
    }
}