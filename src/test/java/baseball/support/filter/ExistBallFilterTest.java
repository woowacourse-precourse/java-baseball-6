package baseball.support.filter;

import baseball.domain.player.value.Ball;
import baseball.domain.player.value.Balls;
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

    @Test
    @DisplayName("Balls를 넘겨 받아 존재하는 Ball만 필터링한다.")
    void filterBall() {
        // given
        Ball BALL_ONE = Ball.of(1L);
        Ball BALL_TWO = Ball.of(2L);
        Ball NOT_FILTERED_BALL = Ball.of(3L);
        Ball NOT_MATCH_BALL = Ball.of(4L);

        List<Ball> balls = List.of(BALL_ONE, BALL_TWO, NOT_FILTERED_BALL);
        List<Ball> tgBalls = List.of(BALL_ONE, BALL_TWO, NOT_MATCH_BALL);

        // when
        Balls filteredBalls = ExistBallFilter.filter(new Balls(balls), new Balls(tgBalls));


        // then
        Assertions.assertAll(
            () -> Assertions.assertEquals(2, filteredBalls.size()),
            () -> Assertions.assertTrue(filteredBalls.isContain(BALL_ONE)),
            () -> Assertions.assertTrue(filteredBalls.isContain(BALL_TWO)),
            () -> Assertions.assertFalse(filteredBalls.isContain(NOT_FILTERED_BALL)),
            () -> Assertions.assertFalse(filteredBalls.isContain(NOT_MATCH_BALL))
        );
    }
}