package baseball.module;

import baseball.input.InputValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    private InputValidator inputValidator;

    @BeforeEach
    void setUp(){
        inputValidator = new InputValidator();
    }

    @Test
    @DisplayName("숫자가 아니면 예외")
    void checkIsInteger() {
        Assertions.assertThrows(IllegalArgumentException.class,()-> inputValidator.validateIsInteger("1o3"));
        Assertions.assertThrows(IllegalArgumentException.class,()-> inputValidator.validateIsInteger("! +"));
    }

    @Test
    @DisplayName("중복된 수 있으면 예외")
    void checkDuplicate() {
        Assertions.assertThrows(IllegalArgumentException.class,()-> inputValidator.validateNoDuplicate("223"));
    }

    @Test
    @DisplayName("3자리 수가 아니면 예외")
    void checkRightDigit() {
        Assertions.assertThrows(IllegalArgumentException.class,()-> inputValidator.validateLength("53"));
    }

    @Test
    @DisplayName("1,2가 아니면 예외")
    void checkIsRightChoice() {
        Assertions.assertThrows(IllegalArgumentException.class,()-> inputValidator.validateChoice("8"));
    }
}