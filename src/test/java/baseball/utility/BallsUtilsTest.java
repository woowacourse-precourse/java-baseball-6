package baseball.utility;

import baseball.domain.balls.Ball;
import baseball.domain.balls.Balls;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BallsUtilsTest {

    @Test
    void 문자열_Balls_변환_테스트() {
        // given
        String string = "123";
        Ball ball1 = new Ball(1, 0);
        Ball ball2 = new Ball(2, 1);
        Ball ball3 = new Ball(3, 2);
        Ball ball4 = new Ball(4, 2);

        // when
        Balls balls = BallsUtils.convertStringToBalls(string);
        boolean hasBall1 = balls.hasSameBall(ball1);
        boolean hasBall2 = balls.hasSameBall(ball2);
        boolean hasBall3 = balls.hasSameBall(ball3);
        boolean hasBall4 = balls.hasSameBall(ball4);

        // then
        Assertions.assertTrue(hasBall1);
        Assertions.assertTrue(hasBall2);
        Assertions.assertTrue(hasBall3);
        Assertions.assertFalse(hasBall4);
    }

}
