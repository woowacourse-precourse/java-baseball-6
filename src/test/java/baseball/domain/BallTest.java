package baseball.domain;


import baseball.domain.Ball;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BallTest {

    @Test
    void 같은값_같은위치는_isSame() {
        Ball ball = new Ball(1, 0);
        Ball other = new Ball(1, 0);

        Assertions.assertTrue(ball.isSame(other));
    }

    @Test
    void 값만같고_위치가다르면_isOnlySameValue() {
        Ball ball = new Ball(1, 0);
        Ball other = new Ball(1, 1);

        Assertions.assertTrue(ball.isOnlySameValue(other));
    }

    @Test
    void 같은값_다른위치는_isNotSame() {
        Ball ball = new Ball(1, 0);
        Ball other = new Ball(1, 1);

        Assertions.assertFalse(ball.isSame(other));
    }

    @Test
    void 값다르고_위치다르면_isOnlySameValue() {
        Ball ball = new Ball(1, 0);
        Ball other = new Ball(2, 1);

        Assertions.assertFalse(ball.isOnlySameValue(other));
    }


}
