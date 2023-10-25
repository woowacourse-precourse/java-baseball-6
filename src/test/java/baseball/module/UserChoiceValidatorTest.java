package baseball.module;

import baseball.input.validator.UserChoiceValidator;
import baseball.input.validator.UserGuessValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserChoiceValidatorTest {
    private UserChoiceValidator userChoiceValidator;

    @BeforeEach
    void setUp(){
        userChoiceValidator = new UserChoiceValidator();
    }

    @Test
    @DisplayName("숫자가 아니면 예외")
    void checkIsInteger() {
        Assertions.assertThrows(IllegalArgumentException.class,()-> userChoiceValidator.validateIsInteger("1o3"));
        Assertions.assertThrows(IllegalArgumentException.class,()-> userChoiceValidator.validateIsInteger("! +"));
    }

    @Test
    @DisplayName("null있으 예외")
    void checkDuplicate() {
        Assertions.assertThrows(IllegalArgumentException.class,()-> userChoiceValidator.validate("223"));
    }

    @Test
    @DisplayName("1,2가 아니면 예외")
    void checkIsRightChoice() {
        Assertions.assertThrows(IllegalArgumentException.class,()-> userChoiceValidator.validateChoice("8"));
    }
}