package baseball.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputValidatorTest {

    @Test
    void testValidPlayerNumbers() {
        assertDoesNotThrow(() -> InputValidator.isValidPlayerNumber("123"));
        assertDoesNotThrow(() -> InputValidator.isValidPlayerNumber("456"));
        assertDoesNotThrow(() -> InputValidator.isValidPlayerNumber("789"));
    }

    @Test
    void testInvalidPlayerNumbers() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.isValidPlayerNumber("112"));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.isValidPlayerNumber("12"));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.isValidPlayerNumber("1234"));
    }

    @Test
    void testValidRestartOrEndNumbers() {
        assertDoesNotThrow(() -> InputValidator.isValidRestartOrEndNumber("1"));
        assertDoesNotThrow(() -> InputValidator.isValidRestartOrEndNumber("2"));
    }

    @Test
    void testInvalidRestartOrEndNumbers() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.isValidRestartOrEndNumber("0"));  // Invalid input
        assertThrows(IllegalArgumentException.class, () -> InputValidator.isValidRestartOrEndNumber("3"));  // Invalid input
    }
}
