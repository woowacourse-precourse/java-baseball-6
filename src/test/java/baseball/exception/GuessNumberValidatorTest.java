package baseball.exception;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GuessNumberValidatorTest {

    @Test
    @DisplayName("문자가 입력으로 들어오면 예외가 발생해야 한다.")
    void isNotNumeric_Test() {
        assertThrows(IllegalArgumentException.class, () -> {
            GuessNumberValidator.isGuessNumberValid(Integer.valueOf('c'));
        });
    }

    @Test
    @DisplayName("0이 입력으로 들어오면 예외가 발생해야 한다.")
    void isNotBetweenOneAndNine_Test() {
        assertThrows(IllegalArgumentException.class, () -> {
            GuessNumberValidator.isGuessNumberValid(0);
        });
    }
}