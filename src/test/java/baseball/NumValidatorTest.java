package baseball;

import baseball.util.Messages;
import baseball.util.NumValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumValidatorTest {
    @Test
    void testValidInput() {
        // 유효한 입력이면 아무 예외도 발생하지 않아야 함
        assertDoesNotThrow(() -> NumValidator.isValid("123"));
    }

    @Test
    void testInvalidLength() {
        // 길이가 4인 입력은 예외 발생해야 함
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> NumValidator.isValid("1234"));
        assertEquals(Messages.LENGTH_ERROR_MESSAGE, exception.getMessage());
    }

    @Test
    void testOutOfRange() {
        // 범위를 벗어나는 입력은 예외 발생해야 함
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> NumValidator.isValid("120"));
        assertEquals(Messages.RANGE_ERROR_MESSAGE, exception.getMessage());
    }

    @Test
    void testDuplicateNumbers() {
        // 중복된 숫자가 있는 입력은 예외 발생해야 함
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> NumValidator.isValid("112"));
        assertEquals(Messages.DUPLICATE_ERROR_MESSAGE, exception.getMessage());
    }
}
