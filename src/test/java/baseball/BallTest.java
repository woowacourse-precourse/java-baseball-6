package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallTest {
    @Test
    @DisplayName("단일 공 테스트 : 나싱")
    public void isNothing_TEST(){
        Ball ball = new Ball(1,1);
        Ball targetBall = new Ball(2,2);
        assertThat(ball.match(targetBall)).isEqualTo(BallStatus.NOTHING);
    }
    @Test
    @DisplayName("단일 공 테스트 : 스트라이크")
    public void isStrike_TEST(){
        Ball ball = new Ball(1,1);
        Ball targetBall = new Ball(1,1);
        assertThat(ball.match(targetBall)).isEqualTo(BallStatus.STRIKE);
    }
    @Test
    @DisplayName("단일 공 테스트 : 볼")
    public void isBall_TEST(){
        Ball ball = new Ball(1,1);
        Ball targetBall = new Ball(2,1);
        assertThat(ball.match(targetBall)).isEqualTo(BallStatus.BALL);
    }
}
