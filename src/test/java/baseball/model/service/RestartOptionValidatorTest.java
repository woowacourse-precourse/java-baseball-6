package baseball.model.service;

import static baseball.model.constants.ExceptionMessages.RESTART_OPTION_LENGTH_INVALID;
import static baseball.model.constants.ExceptionMessages.RESTART_OPTION_NON_NUMBER;
import static baseball.model.constants.ExceptionMessages.RESTART_OPTION_RANGE_INVALID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RestartOptionValidatorTest {
    @Test
    @DisplayName("숫자를 입력하지 않아 예외가 발생합니다.")
    void 숫자이외입력예외() {
        RestartOptionValidator restartOptionValidator = new RestartOptionValidatorImp();
        String option = "A";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            restartOptionValidator.isNonNumber(option);
        });

        assertEquals(RESTART_OPTION_NON_NUMBER, exception.getMessage());
    }

    @Test
    @DisplayName("한 자리를 입력하지 않아 예외가 발생합니다.")
    void 갯수입력예외() {
        RestartOptionValidator restartOptionValidator = new RestartOptionValidatorImp();
        String option = "12";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            restartOptionValidator.isLengthCorrect(option);
        });

        assertEquals(RESTART_OPTION_LENGTH_INVALID, exception.getMessage());
    }

    @Test
    @DisplayName("1 또는 2를 입력하지 않아 예외가 발생합니다.")
    void 범위입력예외() {
        RestartOptionValidator restartOptionValidator = new RestartOptionValidatorImp();
        Integer option = 3;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            restartOptionValidator.isRange(option);
        });

        assertEquals(RESTART_OPTION_RANGE_INVALID, exception.getMessage());
    }


}