package baseball.module;

import baseball.input.InputValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        this.inputValidator = new InputValidator();
    }

    @Test
    @DisplayName("null이면 예외")
    void validateNotNull() {
        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> inputValidator.validateUserGuess(""));
    }

    @Test
    @DisplayName("숫자가 아니면 예외")
    void validateIsInteger() {
        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> inputValidator.validateUserGuess("k"));
    }

    @Test
    @DisplayName("수에 중복이 있으면 예외")
    void validateNoDuplicate() {
        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> inputValidator.validateUserGuess("111"));
    }

    @Test
    @DisplayName("올바른 자릿수가 아니면 예외")
    void validateLength() {
        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> inputValidator.validateUserGuess("89064"));
    }

    @Test
    @DisplayName("1,2가 아니면 예외")
    void validateChoice() {
        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> inputValidator.validateUserChoice("8"));
    }
}