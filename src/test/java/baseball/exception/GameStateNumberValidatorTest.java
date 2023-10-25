package baseball.exception;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameStateNumberValidatorTest {

    @Test
    @DisplayName("1은 입력으로 들어올 수 있다.")
    void isGameStateNumberValid_One_Test() {
        assertTrue(GameStateNumberValidator.isGameStateNumberValid("1"));
    }

    @Test
    @DisplayName("2는 입력으로 들어올 수 있다.")
    void isGameStateNumberValid_Two_Test() {
        assertTrue(GameStateNumberValidator.isGameStateNumberValid("2"));
    }

    @Test
    @DisplayName("빈 문자열이 입력으로 들어오면 예외가 발생한다.")
    void emptyString_Test() {
        assertThrows(IllegalArgumentException.class, () -> {
            GameStateNumberValidator.isGameStateNumberValid("");
        });
    }

    @Test
    @DisplayName("길이가 2이상인 입력이 들어오면 예외가 발생한다.")
    void isLengthOne_Test() {
        assertThrows(IllegalArgumentException.class, () -> {
            GameStateNumberValidator.isGameStateNumberValid("12");
        });
    }

    @Test
    @DisplayName("1 또는 2가아닌 숫자가 입력으로 들어오면 예외가 발생한다.")
    void isEqualToOneOrTwo_Test() {
        assertThrows(IllegalArgumentException.class, () -> {
            GameStateNumberValidator.isGameStateNumberValid("3");
        });
    }
}