package baseball.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserInputNumberValidatorTest {

    @Test
    void validate_validNumber() {
        String validInput = "123";
        assertDoesNotThrow(() -> UserInputNumberValidator.validate(validInput));
    }

    @Test
    void valid_invalidNumberSize() {
        String shortInput = "12";
        String longInput = "1234";
        assertThrows(IllegalArgumentException.class,
            () -> UserInputNumberValidator.validate(shortInput));
        assertThrows(IllegalArgumentException.class,
            () -> UserInputNumberValidator.validate(longInput));
    }

    @Test
    void valid_nonDigitInput() {
        String nonDigitInput = "12a";
        assertThrows(IllegalArgumentException.class,
            () -> UserInputNumberValidator.validate(nonDigitInput));
    }

    @Test
    void valid_inputWithNoRange() {
        String noRangeInput = "012";
        assertThrows(IllegalArgumentException.class,
            () -> UserInputNumberValidator.validate(noRangeInput));
    }

    @Test
    void valid_inputWithDuplication() {
        String duplicatedInput = "112";
        assertThrows(IllegalArgumentException.class,
            () -> UserInputNumberValidator.validate(duplicatedInput));
    }

}