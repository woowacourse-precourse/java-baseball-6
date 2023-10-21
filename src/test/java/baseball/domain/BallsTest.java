package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.domain.score.Hint;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BallsTest {
    private final Balls firstBalls = Balls.from(List.of(1, 2, 3));
    private static final String STRIKE = Hint.STRIKE.value();
    private static final String BALL = Hint.BALL.value();
    private static final String NOTHING = Hint.NOTHING.value();

    @Test
    void 중복_숫자_입력시_예외() {
        List<Integer> input = List.of(1, 1, 1);
        assertThatThrownBy(() -> Balls.from(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 길이가_3보다_크면_예외() {
        List<Integer> input = List.of(1, 2, 3, 4);
        assertThatThrownBy(() -> Balls.from(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 힌트_계산_테스트() {
        assertBallsEquals(Balls.from(List.of(1, 2, 3)), String.format("%d%s", 3, STRIKE));
        assertBallsEquals(Balls.from(List.of(1, 2, 4)), String.format("%d%s", 2, STRIKE));
        assertBallsEquals(Balls.from(List.of(1, 4, 5)), String.format("%d%s", 1, STRIKE));
        assertBallsEquals(Balls.from(List.of(1, 3, 2)), String.format("%d%s %d%s", 2, BALL, 1, STRIKE));
        assertBallsEquals(Balls.from(List.of(1, 3, 4)), String.format("%d%s %d%s", 1, BALL, 1, STRIKE));
        assertBallsEquals(Balls.from(List.of(2, 1, 4)), String.format("%d%s", 2, BALL));
        assertBallsEquals(Balls.from(List.of(2, 5, 4)), String.format("%d%s", 1, BALL));
        assertBallsEquals(Balls.from(List.of(4, 5, 6)), NOTHING);
    }

    private void assertBallsEquals(Balls secondBalls, String expected) {
        assertEquals(firstBalls.compare(secondBalls), expected);
    }
}
