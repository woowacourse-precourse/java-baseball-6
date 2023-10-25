package baseball;

import balls.Balls;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BallsTest {
    @Test
    public void 볼_개수_세는_테스트() {
        //given
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));
        Balls userBalls = new Balls(Arrays.asList(3, 1, 2));
        //when
        int ball = computerBalls.countBall(userBalls);
        //then
        Assertions.assertEquals(3, ball);
    }

    @Test
    public void 스트라이크_개수_세는_테스트() {
        //given
        Balls computerBalls = new Balls(Arrays.asList(8, 6, 9));
        Balls userBalls = new Balls(Arrays.asList(7, 6, 9));
        //when
        int strike = computerBalls.countStrike(userBalls);
        //then
        Assertions.assertEquals(2, strike);
    }
}
