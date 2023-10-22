package baseball.model.service;

import static baseball.model.constants.ExceptionMessage.RESTART_LENGTH_IS_WRONG;
import static baseball.model.constants.ExceptionMessage.RESTART_NOT_NUMBER;
import static baseball.model.constants.ExceptionMessage.RESTART_RANGE_IS_WRONG;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RestartNumberTest {
    @Test
    @DisplayName("숫자를 입력하지 않아 예외가 발생합니다.")
    void 숫자이외입력예외() {
        RestartNumber restartNumber = new RestartNumberImpl();
        String number = "A";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            restartNumber.isNonNumber(number);
        });

        assertEquals(RESTART_NOT_NUMBER, exception.getMessage());
    }

    @Test
    @DisplayName("한 자리를 입력하지 않아 예외가 발생합니다.")
    void 갯수입력예외() {
        RestartNumber restartNumber = new RestartNumberImpl();
        String number = "12";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            restartNumber.isLengthCorrect(number);
        });

        assertEquals(RESTART_LENGTH_IS_WRONG, exception.getMessage());
    }

    @Test
    @DisplayName("1 또는 2를 입력하지 않아 예외가 발생합니다.")
    void 범위입력예외() {
        RestartNumber restartNumber = new RestartNumberImpl();
        Integer number = 3;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            restartNumber.isRange(number);
        });

        assertEquals(RESTART_RANGE_IS_WRONG, exception.getMessage());
    }


}