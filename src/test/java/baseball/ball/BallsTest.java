package baseball.ball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallsTest {
    Balls balls;
    @BeforeEach
    void setUp(){
        balls = new Balls(Arrays.asList(1,2,3));
    }

    @Test
    @DisplayName("복수 공 단일공 비교 테스트 : 나싱")
    public void isNothing_TEST(){
        Ball targetBall = new Ball(2,7);
        assertThat(balls.match(targetBall)).isEqualTo(BallStatus.NOTHING);
    }
    @Test
    @DisplayName("복수 공 단일공 비교 테스트 : 스트라이크")
    public void isStrike_TEST(){
        Ball targetBall = new Ball(1,1);
        assertThat(balls.match(targetBall)).isEqualTo(BallStatus.STRIKE);
    }
    @Test
    @DisplayName("복수 공 단일공 비교 테스트 : 볼")
    public void isBall_TEST(){
        Ball targetBall = new Ball(2,1);
        assertThat(balls.match(targetBall)).isEqualTo(BallStatus.BALL);
    }
}
