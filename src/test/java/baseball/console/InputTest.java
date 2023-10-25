package baseball.console;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {

    @Test
    void isValidNumber_With_Valid_Number() {
        assertTrue(Input.isValidateNumber("123"));
    }

    @Test
    void isNotValidNumber_With_Invalid_Length() {
        assertFalse(Input.isValidateNumber("12"));
        assertFalse(Input.isValidateNumber("1234"));
    }

    @Test
    void isNotValidNumber_With_Alphabets() {
        assertFalse(Input.isValidateNumber("12a"));
    }

    @Test
    void isNotValidNumber_With_Zero() {
        assertFalse(Input.isValidateNumber("120"));
    }

    @Test
    void isNotValidNumber_With_Duplicates() {
        assertFalse(Input.isValidateNumber("112"));
    }

    @Test
    void isValidRestartNumber() {
        assertTrue(Input.isValidRestartNumber("1"));
        assertTrue(Input.isValidRestartNumber("2"));
        assertFalse(Input.isValidRestartNumber("3"));
    }
}

