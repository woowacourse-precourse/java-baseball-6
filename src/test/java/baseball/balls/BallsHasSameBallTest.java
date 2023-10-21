package baseball.balls;

import baseball.testUtils.BallsGeneratorUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BallsHasSameBallTest {

    @Test
    void 같은_값의_공_포함() {
        // given
        Balls balls = BallsGeneratorUtil.generateBalls();

        // when
        int expectedBallValue = BallValue.MIN_VALUE;
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
        int expectedBallValue = BallValue.MAX_VALUE;
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
        int expectedBallValue = BallValue.MIN_VALUE;
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
        int expectedBallValue = BallValue.MAX_VALUE;
        int expectedBallIndex = Balls.BALL_COUNT - 1;
        Ball expectedBall = new Ball(expectedBallValue, expectedBallIndex);

        // then
        Assertions.assertFalse(balls.hasSameValueBall(expectedBall));
    }

}
