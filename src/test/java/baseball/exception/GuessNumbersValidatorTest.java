package baseball.exception;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GuessNumbersValidatorTest {

    @Test
    @DisplayName("중복없는 1-9 사이의 3자리 숫자는 입력으로 들어올 수 있다.")
    void validInput() {
        assertTrue(GuessNumbersValidator.isGuessNumbersValid("123"));
        assertTrue(GuessNumbersValidator.isGuessNumbersValid("945"));
        assertTrue(GuessNumbersValidator.isGuessNumbersValid("187"));
        assertTrue(GuessNumbersValidator.isGuessNumbersValid("328"));
    }

    @Test
    @DisplayName("입력의 길이가 3이 아닐 시 예외가 발생해야 한다.")
    void isLengthNotThree() {
        assertThrows(IllegalArgumentException.class, () -> {
            GuessNumbersValidator.isGuessNumbersValid("12");
        });
    }

    @Test
    @DisplayName("입력에 중복된 숫자가 있을 시 예외가 발생해야 한다.")
    void isDuplicate_Test() {
        assertThrows(IllegalArgumentException.class, () -> {
            GuessNumbersValidator.isGuessNumbersValid("112");
        });
    }
}