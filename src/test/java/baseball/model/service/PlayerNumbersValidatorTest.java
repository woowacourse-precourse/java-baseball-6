package baseball.model.service;

import static baseball.model.constants.ExceptionMessages.PLAYER_NUMBERS_DUPLICATED;
import static baseball.model.constants.ExceptionMessages.PLAYER_NUMBERS_LENGTH_INVALID;
import static baseball.model.constants.ExceptionMessages.PLAYER_NUMBERS_NON_NUMBER;
import static baseball.model.constants.ExceptionMessages.PLAYER_NUMBERS_RANGE_INVALID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerNumbersValidatorTest {
    @Test
    @DisplayName("숫자를 입력하지 않아 예외가 발생합니다.")
    void 숫자이외입력예외() {
        PlayerNumbersValidator playerNumbersValidator = new PlayerNumbersValidatorImp();
        String numbers = "12A";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            playerNumbersValidator.isNonNumber(numbers);
        });

        assertEquals(PLAYER_NUMBERS_NON_NUMBER, exception.getMessage());
    }

    @Test
    @DisplayName("세 자리를 입력하지 않아 예외가 발생합니다.")
    void 갯수입력예외() {
        PlayerNumbersValidator playerNumbersValidator = new PlayerNumbersValidatorImp();
        List<Integer> numbers = Arrays.asList(1, 2);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            playerNumbersValidator.isLengthCorrect(numbers);
        });

        assertEquals(PLAYER_NUMBERS_LENGTH_INVALID, exception.getMessage());
    }

    @Test
    @DisplayName("1에서 9 범위를 입력하지 않아 예외가 발생합니다.")
    void 범위입력예외() {
        PlayerNumbersValidator playerNumbersValidator = new PlayerNumbersValidatorImp();
        List<Integer> numbers = Arrays.asList(1, 2, 0);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            playerNumbersValidator.isRange(numbers);
        });

        assertEquals(PLAYER_NUMBERS_RANGE_INVALID, exception.getMessage());
    }

    @Test
    @DisplayName("서로 다른 수를 입력하지 않아 예외가 발생합니다.")
    void 중복입력예외() {
        PlayerNumbersValidator playerNumbersValidator = new PlayerNumbersValidatorImp();
        List<Integer> numbers = Arrays.asList(1, 2, 2);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            playerNumbersValidator.isDuplicate(numbers);
        });

        assertEquals(PLAYER_NUMBERS_DUPLICATED, exception.getMessage());
    }

}