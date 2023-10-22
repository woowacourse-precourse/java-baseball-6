package baseball.support.filter;

import baseball.domain.player.defender.support.BallSource;
import baseball.domain.player.value.Ball;
import baseball.support.converter.BallSourceConverter;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExistBallFilterTest {

    @Test
    @DisplayName("존재하는 Ball만 필터링한다.")
    void filter() {
        // given
        Ball BALL_ONE = Ball.of(1L);
        Ball BALL_TWO = Ball.of(2L);
        Ball NOT_FILTERED_BALL = Ball.of(3L);
        Ball NOT_MATCH_BALL = Ball.of(4L);

        List<Ball> balls = List.of(BALL_ONE, BALL_TWO, NOT_FILTERED_BALL);
        List<Ball> tgBalls = List.of(BALL_ONE, BALL_TWO, NOT_MATCH_BALL);

        // when
        List<Ball> filtered = ExistBallFilter.filter(balls, tgBalls);

        // then
        Assertions.assertAll(
            () -> Assertions.assertEquals(2, filtered.size()),
            () -> Assertions.assertTrue(filtered.contains(BALL_ONE)),
            () -> Assertions.assertTrue(filtered.contains(BALL_TWO)),
            () -> Assertions.assertFalse(filtered.contains(NOT_FILTERED_BALL)),
            () -> Assertions.assertFalse(filtered.contains(NOT_MATCH_BALL))
        );
    }
}