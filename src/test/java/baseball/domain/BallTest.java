package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BallTest {

    @Test
    void Ball_동등성() {
        Ball ball = new Ball(new Position(1), new BallNum(5));
        assertThat(ball).isEqualTo(new Ball(new Position(1), new BallNum(5)));
    }

    @Test
    void Ball_STRIKE상황() {
        Ball ball = new Ball(new Position(1), new BallNum(5));
        Ball ball2 = new Ball(new Position(1), new BallNum(5));
        assertThat(ball.match(ball2)).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void Ball_BALL상황() {
        Ball ball = new Ball(new Position(1), new BallNum(5));
        Ball ball2 = new Ball(new Position(3), new BallNum(5));
        assertThat(ball.match(ball2)).isEqualTo(BallStatus.BALL);
    }

    @Test
    void Ball_NOTHING상황() {
        Ball ball = new Ball(new Position(1), new BallNum(5));
        Ball ball2 = new Ball(new Position(2), new BallNum(3));
        assertThat(ball.match(ball2)).isEqualTo(BallStatus.NOTHING);
    }
}
