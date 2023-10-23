package baseball.domain.player.value;

import static org.junit.jupiter.api.Assertions.*;

import baseball.domain.player.defender.value.BallCount;
import baseball.domain.player.defender.value.Result;
import baseball.domain.player.defender.value.Results;
import baseball.domain.player.defender.value.StrikeCount;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BallsTest {

    static final Ball BALL_ONE = Ball.of(1L);
    static final Ball BALL_TWO = Ball.of(2L);
    static final Ball BALL_THREE = Ball.of(3L);
    static final Ball BALL_FOUR = Ball.of(4L);
    static final List<Ball> BALLS_SOURCE = List.of(BALL_ONE, BALL_TWO, BALL_THREE);

    @Test
    @DisplayName("Balls에서 Ball이 존재하는지 확인한다.")
    void isContain() {
        // given
        Balls source = new Balls(BALLS_SOURCE);

        // when
        boolean containBall = source.isContain(BALL_ONE);
        boolean notContainBall = source.isContain(BALL_FOUR);

        // then
        Assertions.assertAll(
            () -> assertTrue(containBall),
            () -> assertFalse(notContainBall)
        );
    }

    @Test
    @DisplayName("Balls에서 Ball의 위치를 확인한다.")
    void position() {
        // given
        Balls source = new Balls(BALLS_SOURCE);

        // when
        boolean rightPosition = source.isSame(BALL_ONE, 0L);
        boolean wrongPosition = source.isSame(BALL_ONE, 1L);
        boolean outOfIndex = source.isSame(BALL_ONE, source.size());

        // then
        Assertions.assertAll(
            () -> assertTrue(rightPosition),
            () -> assertFalse(wrongPosition),
            () -> assertFalse(outOfIndex)
        );
    }

    @DisplayName("Balls를 통해 결과를 계산한다.")
    @ParameterizedTest
    @CsvSource(
        value = {
            "1:2:3:3:0", // 3 strike
            "1:2:4:2:0", // 2 strike
            "1:4:5:1:0", // 1 strike
            "3:1:2:0:3", // 3 ball
            "4:1:2:0:2", // 2 ball
            "4:5:1:0:1", // 1 ball
            "4:5:6:0:0", // noting
        },
        delimiter = ':')
    void compareBalls(long n1, long n2, long n3, long strikeCount, long ballCount) {
        // given
        List<Ball> balls = List.of(Ball.of(n1), Ball.of(n2), Ball.of(n3));

        Balls source = new Balls(balls);
        Balls target = new Balls(BALLS_SOURCE);

        // when
        List<Ball> filteredBalls = new ArrayList<>();
        for (int i = 0; i < target.size(); i++) {
            Ball ball = target.getBall(i);
            if (source.isContain(ball)) {
                filteredBalls.add(ball);
            }
        }

        List<Result> calculatedResult = new ArrayList<>();
        int totalBall = filteredBalls.size();
        for (int i = 0; i < totalBall; i++) {
            Ball ball = filteredBalls.get(i);
            if (source.isSame(ball, (long) i)) {
                calculatedResult.add(Result.STRIKE);
                continue;
            }
            calculatedResult.add(Result.BALL);
        }

        Results results = new Results(calculatedResult);

        // then
        assertEquals(new StrikeCount(strikeCount), results.getStrikeCount());
        assertEquals(new BallCount(ballCount), results.getBallCount());
    }
}