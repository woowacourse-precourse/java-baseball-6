package baseball.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {
    @Test
    void validateAnswer_유효한_답변() {
        InputValidator inputValidator = new InputValidator();
        String validAnswer = "123";

        Assertions.assertDoesNotThrow(() -> inputValidator.validateAnswer(validAnswer));
    }

    @Test
    void validateAnswer_NULL_예외() {
        InputValidator inputValidator = new InputValidator();

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateAnswer(null);
        });

        String message = exception.getMessage();
        Assertions.assertEquals("입력값은 Null 값이 아니어야 합니다.", message);
    }

    @Test
    void validateAnswer_문자_예외() {
        InputValidator inputValidator = new InputValidator();
        String invalidAnswer = "abc";

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateAnswer(invalidAnswer);
        });

        String message = exception.getMessage();
        Assertions.assertEquals("입력값은 숫자이어야 합니다.", message);
    }

    @Test
    void validateAnswer_길이초과_예외() {
        InputValidator inputValidator = new InputValidator();
        String invalidAnswer = "12345";

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateAnswer(invalidAnswer);
        });

        String message = exception.getMessage();
        Assertions.assertEquals("입력값의 길이는 3이어야 합니다.", message);
    }

    @Test
    void validateAnswer_길이부족_예외() {
        InputValidator inputValidator = new InputValidator();
        String invalidAnswer = "12";

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateAnswer(invalidAnswer);
        });

        String message = exception.getMessage();
        Assertions.assertEquals("입력값의 길이는 3이어야 합니다.", message);
    }

    @Test
    void validateAnswer_중복숫자_예외() {
        InputValidator inputValidator = new InputValidator();
        String invalidAnswer = "112";

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateAnswer(invalidAnswer);
        });

        String message = exception.getMessage();
        Assertions.assertEquals("입력값으로는 중복되지 않은 숫자를 입력해야 합니다.", message);
    }

    @Test
    void validateContinue_유효한_입력() {
        InputValidator inputValidator = new InputValidator();
        String validInput = "1";

        Assertions.assertDoesNotThrow(() -> {
            inputValidator.validateContinue(validInput);
        });
    }

    @Test
    void validateContinue_NULL_예외() {
        InputValidator inputValidator = new InputValidator();

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateContinue(null);
        });

        String message = exception.getMessage();
        Assertions.assertEquals("입력값은 Null 값이 아니어야 합니다.", message);
    }

    @Test
    void validateContinue_문자_예외() {
        InputValidator inputValidator = new InputValidator();
        String invalidInput = "abc";

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateContinue(invalidInput);
        });

        String message = exception.getMessage();
        Assertions.assertEquals("입력값은 숫자이어야 합니다.", message);
    }

    @Test
    void validateContinue_유효하지_않은_입력() {
        InputValidator inputValidator = new InputValidator();
        String invalidInput = "3";

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateContinue(invalidInput);
        });

        String message = exception.getMessage();
        Assertions.assertEquals("입력값으로는 1 또는 2를 입력해야 합니다.", message);
    }
}
