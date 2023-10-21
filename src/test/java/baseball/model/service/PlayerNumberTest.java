package baseball.model.service;

import static baseball.model.constants.ExceptionMessage.LENGTH_IS_WRONG;
import static baseball.model.constants.ExceptionMessage.NOT_NUMBER;
import static baseball.model.constants.ExceptionMessage.NUMBER_DUPLICATED;
import static baseball.model.constants.ExceptionMessage.RANGE_IS_WRONG;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerNumberTest {

    @Test
    @DisplayName("숫자를 입력하지 않아 예외가 발생합니다.")
    void 숫자이외입력예외() {
        PlayerNumber playerNumber = new PlayerNumberImpl();
        String numbers = "12A";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            playerNumber.isNonNumber(numbers);
        });

        assertEquals(NOT_NUMBER, exception.getMessage());
    }

    @Test
    @DisplayName("세 자리를 입력하지 않아 예외가 발생합니다.")
    void 갯수입력예외() {
        PlayerNumber playerNumber = new PlayerNumberImpl();
        List<Integer> numbers = Arrays.asList(1, 2);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            playerNumber.isLengthCorrect(numbers);
        });

        assertEquals(LENGTH_IS_WRONG, exception.getMessage());
    }

    @Test
    @DisplayName("1에서 9 범위를 입력하지 않아 예외가 발생합니다.")
    void 범위입력예외() {
        PlayerNumber playerNumber = new PlayerNumberImpl();
        List<Integer> numbers = Arrays.asList(1, 2, 0);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            playerNumber.isRange(numbers);
        });

        assertEquals(RANGE_IS_WRONG, exception.getMessage());
    }

    @Test
    @DisplayName("서로 다른 수를 입력하지 않아 예외가 발생합니다.")
    void 중복입력예외() {
        PlayerNumber playerNumber = new PlayerNumberImpl();
        List<Integer> numbers = Arrays.asList(1, 2, 2);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            playerNumber.isDuplicate(numbers);
        });

        assertEquals(NUMBER_DUPLICATED, exception.getMessage());
    }

}