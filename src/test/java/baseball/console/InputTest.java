package baseball.console;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {

    @Test
    void isValidNumber_With_Valid_Number() {
        assertTrue(Input.isValidNumber("123"));
    }

    @Test
    void isNotValidNumber_With_Invalid_Length() {
        assertFalse(Input.isValidNumber("12"));
        assertFalse(Input.isValidNumber("1234"));
    }

    @Test
    void isNotValidNumber_With_Alphabets() {
        assertFalse(Input.isValidNumber("12a"));
    }

    @Test
    void isNotValidNumber_With_Zero() {
        assertFalse(Input.isValidNumber("120"));
    }

    @Test
    void isNotValidNumber_With_Duplicates() {
        assertFalse(Input.isValidNumber("112"));
    }

    @Test
    void isValidRestartNumber() {
        assertTrue(Input.isValidRestartNumber("1"));
        assertTrue(Input.isValidRestartNumber("2"));
        assertFalse(Input.isValidRestartNumber("3"));
    }
}

