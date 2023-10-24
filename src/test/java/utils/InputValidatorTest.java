package utils;

import org.junit.jupiter.api.Test;

import static constant.ErrorMessage.*;
import static org.junit.jupiter.api.Assertions.*;
import static utils.InputValidator.validateUserInput;

class InputValidatorTest {

    @Test
    void validateLengthTest() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> validateUserInput("1234"));
        assertEquals(wrongLengthInput, exception.getMessage());
    }

    @Test
    void validateRangeTest() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> validateUserInput("120"));
        assertEquals(wrongRangeInput, exception.getMessage());
    }

    @Test
    void validateNoDuplicateTest() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> validateUserInput("221"));
        assertEquals(hasDuplicateNumber, exception.getMessage());
    }

}