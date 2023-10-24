package baseball.exception;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GuessNumberValidatorTest {

    @Test
    @DisplayName("문자를 입력 시 예외가 발생해야 한다.")
    void isNotNumeric_Test() {
        assertThrows(IllegalArgumentException.class, () -> {
            GuessNumberValidator.isGuessNumberValid(Integer.valueOf('c'));
        });
    }

    @Test
    @DisplayName("0을 입력 시 예외가 발생해야 한다.")
    void isNotBetweenOneAndNine_Test() {
        assertThrows(IllegalArgumentException.class, () -> {
            GuessNumberValidator.isGuessNumberValid(0);
        });
    }
}