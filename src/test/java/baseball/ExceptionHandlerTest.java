package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExceptionHandlerTest {

    @Test
    @DisplayName("유효한 입력 테스트")
    public void testHandleStartValid() {
        ExceptionHandler handler = new ExceptionHandler("123");
        assertDoesNotThrow(() -> handler.handleStart("123"));
        assertDoesNotThrow(() -> handler.handleExecute("123"));
    }

    @Test
    @DisplayName("자리수 범위 벗어난 숫자 테스트")
    public void testHandleStartDigitOne() {
        ExceptionHandler handler = new ExceptionHandler("1");
        assertThrows(IllegalArgumentException.class, () -> handler.handleStart("1"));
    }

    @Test
    @DisplayName("자리수 범위 벗어난 숫자 테스트")
    public void testHandleStartDigitTwo() {
        ExceptionHandler handler = new ExceptionHandler("12");
        assertThrows(IllegalArgumentException.class, () -> handler.handleStart("12"));
    }

    @Test
    @DisplayName("범위 밖 숫자 테스트")
    public void testHandleStartRangeOut() {
        ExceptionHandler handler = new ExceptionHandler("1234");
        assertThrows(IllegalArgumentException.class, () -> handler.handleStart("1234"));
    }

    @Test
    @DisplayName("숫자가 아닌 입력")
    public void testNotNumeric() {
        ExceptionHandler handler = new ExceptionHandler("abc");
        assertThrows(IllegalArgumentException.class, () -> handler.handleStart("abc"));
    }

}