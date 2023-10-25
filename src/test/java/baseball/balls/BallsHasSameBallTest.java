package baseball.balls;

import baseball.domain.balls.Ball;
import baseball.domain.balls.Balls;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BallsHasSameBallTest {

    private Balls balls;

    @BeforeEach
    void setup() {
        List<Ball> balls = List.of(
                new Ball(1, 0),
                new Ball(2, 1),
                new Ball(3, 2)
        );
        this.balls = new Balls(balls);
    }

    @Test
    void 같은_값의_공_포함() {
        // given
        Ball ball = new Ball(2, 0);

        // when
        boolean hasSameValueBall = balls.hasSameValueBall(ball);

        // then
        Assertions.assertTrue(hasSameValueBall);
    }

    @Test
    void 같은_값의_공_미포함() {
        // given
        Ball ball = new Ball(4, 0);

        // when
        boolean hasSameValueBall = balls.hasSameValueBall(ball);

        // then
        Assertions.assertFalse(hasSameValueBall);
    }

    @Test
    void 같은_공_포함() {
        // given
        Ball ball = new Ball(1, 0);

        // when
        boolean hasSameBall = balls.hasSameBall(ball);

        // then
        Assertions.assertTrue(hasSameBall);
    }

    @Test
    void 같은_공_미포함() {
        // given
        Ball ball = new Ball(2, 0);

        // when
        boolean hasSameBall = balls.hasSameBall(ball);

        // then
        Assertions.assertFalse(hasSameBall);
    }

}
