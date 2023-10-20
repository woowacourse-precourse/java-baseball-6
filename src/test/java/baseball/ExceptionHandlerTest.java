package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExceptionHandlerTest {
    private ExceptionHandler exceptionHandler;

    @BeforeEach
    void setUp(){
        exceptionHandler = new ExceptionHandler();
    }

    @Test
    @DisplayName("숫자가 아니면 예외")
    void checkIsInteger() {
        Assertions.assertThrows(IllegalArgumentException.class,()-> exceptionHandler.isInteger("1o3"));
        Assertions.assertThrows(IllegalArgumentException.class,()-> exceptionHandler.isInteger("! +"));
    }

    @Test
    @DisplayName("중복된 수 있으면 예외")
    void checkDuplicate() {
        Assertions.assertThrows(IllegalArgumentException.class,()-> exceptionHandler.checkDuplicate("223"));
    }

    @Test
    @DisplayName("3자리 수가 아니면 예외")
    void checkRightDigit() {
        Assertions.assertThrows(IllegalArgumentException.class,()-> exceptionHandler.isRightDigit("53"));
    }

    @Test
    @DisplayName("1,2가 아니면 예외")
    void checkIsRightChoice() {
        Assertions.assertThrows(IllegalArgumentException.class,()-> exceptionHandler.checkIsRightChoice(8));
    }
}