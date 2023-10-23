package baseball.balls;

import baseball.testUtils.BallsGeneratorUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BallsHasSameBallTest {

    private static final int BALL_MIN_VALUE = 1;
    private static final int BALL_MAX_VALUE = 9;
    private static final int BALL_COUNT = 3;

    @Test
    void 같은_값의_공_포함() {
        // given
        Balls balls = BallsGeneratorUtil.generateBalls();

        // when
        int expectedBallValue = BALL_MIN_VALUE;
        int expectedBallIndex = 1;
        Ball expectedBall = new Ball(expectedBallValue, expectedBallIndex);

        // then
        Assertions.assertTrue(balls.hasSameValueBall(expectedBall));
    }

    @Test
    void 같은_값의_공_미포함() {
        // given
        Balls balls = BallsGeneratorUtil.generateBalls();

        // when
        int expectedBallValue = BALL_MAX_VALUE;
        int expectedBallIndex = 1;
        Ball expectedBall = new Ball(expectedBallValue, expectedBallIndex);

        // then
        Assertions.assertFalse(balls.hasSameValueBall(expectedBall));
    }

    @Test
    void 같은_공_포함() {
        // given
        Balls balls = BallsGeneratorUtil.generateBalls();

        // when
        int expectedBallValue = BALL_MIN_VALUE;
        int expectedBallIndex = 0;
        Ball expectedBall = new Ball(expectedBallValue, expectedBallIndex);

        // then
        Assertions.assertTrue(balls.hasSameValueBall(expectedBall));
    }

    @Test
    void 같은_공_미포함() {
        // given
        Balls balls = BallsGeneratorUtil.generateBalls();

        // when
        int expectedBallValue = BALL_MAX_VALUE;
        int expectedBallIndex = BALL_COUNT - 1;
        Ball expectedBall = new Ball(expectedBallValue, expectedBallIndex);

        // then
        Assertions.assertFalse(balls.hasSameValueBall(expectedBall));
    }

}
