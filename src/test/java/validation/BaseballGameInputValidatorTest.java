package validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class BaseballGameInputValidatorTest {
    @Test
    void shouldThrownWhenOverflowOfLengthInput() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> BaseballGameInputValidator.validateInput("1234")
        );
    }

    @Test
    void shouldThrownWhenNotDigit() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> BaseballGameInputValidator.validateInput("abc")
        );
    }
}