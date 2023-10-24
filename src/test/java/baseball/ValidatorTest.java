package baseball;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @Test
    public void testCheckValidNumber_ValidInput() {
        Validator validator = new Validator();
        assertDoesNotThrow(() -> validator.checkValidNumber("123"));
    }

    @Test
    public void testCheckValidNumber_InvalidInput() {
        Validator validator = new Validator();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.checkValidNumber("abc"));
        assertEquals("숫자만 입력이 가능합니다.", exception.getMessage());
    }

    @Test
    public void testCheckInputSize_ValidInput() {
        Validator validator = new Validator();
        assertDoesNotThrow(() -> validator.checkInputSize("123", 3));
    }

    @Test
    public void testCheckInputSize_InvalidSize() {
        Validator validator = new Validator();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.checkInputSize("1234", 3));
        assertEquals("사용자 입력값의 크기가 올바르지 않습니다.", exception.getMessage());
    }

    @Test
    public void testCheckNotEmpty_ValidInput() {
        Validator validator = new Validator();
        assertDoesNotThrow(() -> validator.checkNotEmpty("abc"));
    }

    @Test
    public void testCheckNotEmpty_EmptyInput() {
        Validator validator = new Validator();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.checkNotEmpty(""));
        assertEquals("값을 입력해주세요.", exception.getMessage());
    }

    @Test
    public void testCheckNotEmpty_NullInput() {
        Validator validator = new Validator();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.checkNotEmpty(null));
        assertEquals("값을 입력해주세요.", exception.getMessage());
    }
}
