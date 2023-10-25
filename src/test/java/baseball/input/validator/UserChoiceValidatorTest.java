package baseball.input.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserChoiceValidatorTest {
    private UserChoiceValidator userChoiceValidator;

    @BeforeEach
    void setUp(){
        userChoiceValidator = new UserChoiceValidator();
    }

    @Test
    @DisplayName("null이면 예외")
    void validateNotNull() {
        Assertions.assertThrows(IllegalArgumentException.class,()-> userChoiceValidator.validate(""));
    }

    @Test
    @DisplayName("숫자가 아니면 예외")
    void validateIsInteger() {
        Assertions.assertThrows(IllegalArgumentException.class,()-> userChoiceValidator.validate("k"));
    }

    @Test
    @DisplayName("1,2가 아니면 예외")
    void validateChoice() {
        Assertions.assertThrows(IllegalArgumentException.class,()-> userChoiceValidator.validateChoice("8"));
    }
}