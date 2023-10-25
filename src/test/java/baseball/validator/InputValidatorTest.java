package baseball.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    private final InputValidator inputValidator = new InputValidator();

    @Test
    @DisplayName("사용자 입력값에 문자가 포함되어 있으면 예외가 발생한다.")
    void inputValidatorTest1() {
        String input = "a12";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateIsDigit(input);
        });
    }

    @Test
    @DisplayName("사용자 입력값에 공백이 포함되어 있으면 예외가 발생한다.")
    void inputValidatorTest2() {
        String input = "12 ";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateIsDigit(input);
        });
    }

    @Test
    @DisplayName("사용자 입력값에 공백만 있으면 예외가 발생한다.")
    void inputValidatorTest3() {
        String input = " ";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateIsDigit(input);
        });
    }

    @Test
    @DisplayName("사용자 입력값에 문자만 있으면 예외가 발생한다.")
    void inputValidatorTest4() {
        String input = "abc";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateIsDigit(input);
        });
    }
}