package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BallsTest {

    Balls answer;
    Balls playerBalls;

    @BeforeEach
    public void setUp() {
        answer = Balls.of(List.of(1, 2, 3));
    }

    @Test
    void ballsOfTestWithDuplicateNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 2);
        assertThrows(IllegalArgumentException.class, () -> Balls.of(numbers));
    }

    @Test
    void ballsOfTestWithInvalidSize() {
        List<Integer> numbers = Arrays.asList(1, 2);
        assertThrows(IllegalArgumentException.class, () -> Balls.of(numbers));
    }

    @Test
    void compareTest_3STRIKE() {
        playerBalls = Balls.of(List.of(1, 2, 3));
        RoundResult result = playerBalls.compareWith(answer);
        assertEquals("3스트라이크", result.toString());

        assertFalse(result.isNothing());
        assertTrue(result.isGameEnd());
    }

    @Test
    void compareTest_1BALL_1STRIKE() {
        playerBalls = Balls.of(List.of(1, 3, 4));
        RoundResult result = playerBalls.compareWith(answer);
        assertEquals("1볼 1스트라이크", result.toString());

        assertFalse(result.isNothing());
        assertFalse(result.isGameEnd());
    }

    @Test
    void compareTest_NOTHING() {
        playerBalls = Balls.of(List.of(4, 5, 6));
        RoundResult result = playerBalls.compareWith(answer);
        assertEquals("낫싱", result.toString());

        assertTrue(result.isNothing());
        assertFalse(result.isGameEnd());
    }

}