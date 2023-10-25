package baseball.module;

import baseball.input.validator.UserGuessValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserGuessValidatorTest {
    UserGuessValidator userGuessValidator;

    @BeforeEach
    void setUp() {
        this.userGuessValidator= new UserGuessValidator();
    }

    @Test
    @DisplayName("null이면 예외")
    void validateNotNull() {
        Assertions.assertThrows(IllegalArgumentException.class,()-> userGuessValidator.validate(""));
    }

    @Test
    @DisplayName("숫자가 아니면 예외")
    void validateIsInteger() {
        Assertions.assertThrows(IllegalArgumentException.class,()-> userGuessValidator.validate("k"));
    }

    @Test
    @DisplayName("수에 중복이 있으면 예외")
    void validateNoDuplicate() {
        Assertions.assertThrows(IllegalArgumentException.class,()-> userGuessValidator.validate("111"));
    }

    @Test
    @DisplayName("올바른 자릿수가 아니면 예외")
    void validateLength() {
        Assertions.assertThrows(IllegalArgumentException.class,()-> userGuessValidator.validate("89064"));
    }
}