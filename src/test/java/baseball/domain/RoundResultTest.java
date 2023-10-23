package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("RoundResult 클래스 테스트")
class RoundResultTest {

    @Test
    @DisplayName("RoundResult 생성자 테스트")
    void testRoundResultConstructor() {
        List<Integer> guessedNumbers = Arrays.asList(1, 2, 3);
        List<Integer> answerNumbers = Arrays.asList(1, 2, 3);
        RoundResult roundResult = RoundResult.of(guessedNumbers, answerNumbers);

        assertEquals(3, roundResult.getStrikeCount());
        assertEquals(0, roundResult.getBallCount());
    }

    @Nested
    @DisplayName("toString 메소드 테스트")
    class ToStringTests {
        @Test
        @DisplayName("낫싱인 경우")
        void testToStringNothing() {
            List<Integer> guessedNumbers = Arrays.asList(1, 2, 3);
            List<Integer> answerNumbers = Arrays.asList(4, 5, 6);
            RoundResult roundResult = RoundResult.of(guessedNumbers, answerNumbers);

            assertEquals("낫싱", roundResult.toString());
        }

        @Test
        @DisplayName("볼과 스트라이크가 같이 있는 경우")
        void testRoundResultToStringWithBallAndStrike() {
            List<Integer> guessedNumbers = Arrays.asList(1, 2, 3);
            List<Integer> answerNumbers = Arrays.asList(1, 9, 2);
            RoundResult roundResult = RoundResult.of(guessedNumbers, answerNumbers);

            assertEquals("1볼 1스트라이크", roundResult.toString());
        }

        @Test
        @DisplayName("볼만 있는 경우")
        void testRoundResultToStringAllBalls() {
            List<Integer> guessedNumbers = Arrays.asList(1, 2, 3);
            List<Integer> answerNumbers = Arrays.asList(3, 1, 2);
            RoundResult roundResult = RoundResult.of(guessedNumbers, answerNumbers);

            assertEquals("3볼", roundResult.toString());
        }

        @Test
        @DisplayName("스트라이크만 있는 경우")
        void testRoundResultToStringAllStrikes() {
            List<Integer> guessedNumbers = Arrays.asList(1, 2, 3);
            List<Integer> answerNumbers = Arrays.asList(1, 2, 3);
            RoundResult roundResult = RoundResult.of(guessedNumbers, answerNumbers);

            assertEquals("3스트라이크", roundResult.toString());
        }
    }

    @Nested
    @DisplayName("isCorrect 메소드 테스트")
    class IsCorrectTests {
        @Test
        @DisplayName("정답인 경우")
        void testRoundResultIsCorrectWithCorrectGuess() {
            List<Integer> guessedNumbers = Arrays.asList(1, 2, 3);
            List<Integer> answerNumbers = Arrays.asList(1, 2, 3);
            RoundResult roundResult = RoundResult.of(guessedNumbers, answerNumbers);

            assertTrue(roundResult.isCorrect());
        }

        @Test
        @DisplayName("정답이 아닌 경우")
        void testRoundResultIsCorrectWithIncorrectGuess() {
            List<Integer> guessedNumbers = Arrays.asList(1, 2, 3);
            List<Integer> answerNumbers = Arrays.asList(4, 5, 6);
            RoundResult roundResult = RoundResult.of(guessedNumbers, answerNumbers);
            roundResult.matchNumbers(guessedNumbers, answerNumbers);

            assertFalse(roundResult.isCorrect());
        }
    }
}
