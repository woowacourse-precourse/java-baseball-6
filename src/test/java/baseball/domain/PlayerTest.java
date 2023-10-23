package baseball.domain;

import baseball.exception.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Player 클래스 테스트")
class PlayerTest {

    @Test
    @DisplayName("Player 생성 테스트")
    void testPlayerConstructor() {
        Player player = new Player();

        List<Integer> guessedNumbers = player.guessNumbers("123");

        assertEquals(3, guessedNumbers.size());
        assertEquals(List.of(1, 2, 3), player.getGuessedNumbers());
    }

    @Nested
    @DisplayName("입력값 검증 테스트")
    class InputValidationTest {
        @Test
        @DisplayName("입력값이 숫자가 아닌 경우")
        void testGuessNumbersInvalidInputNotNumber() {
            Player player = new Player();

            assertThrows(InvalidInputException.class, () -> player.guessNumbers("abc"));
        }

        @Test
        @DisplayName("입력값이 3자리가 아닌 경우")
        void testGuessNumbersInvalidInputLength() {
            Player player = new Player();

            assertAll(
                    () -> assertThrows(InvalidInputException.class, () -> player.guessNumbers("12")),
                    () -> assertThrows(InvalidInputException.class, () -> player.guessNumbers("1234"))
            );

        }

        @Test
        @DisplayName("입력값에 중복된 숫자가 있는 경우")
        void testGuessNumbersInvalidInputDuplicate() {
            Player player = new Player();

            assertThrows(InvalidInputException.class, () -> player.guessNumbers("112"));
        }

        @Test
        @DisplayName("입력값에 범위를 벗어난 숫자가 있는 경우 - 0이 들어간 경우")
        void testGuessNumbersInvalidInputRange() {
            Player player = new Player();

            assertThrows(InvalidInputException.class, () -> player.guessNumbers("012"));
        }
    }
}