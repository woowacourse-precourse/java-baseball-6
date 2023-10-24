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
    @DisplayName("복수 공 ,북수 공 비교 테스트 : 나싱")
    public void BALLS_NOTHING_TEST(){
        Balls targetBalls = new Balls(Arrays.asList(4,5,6));
        SwingResult swingResult = balls.match(targetBalls);
        assertThat(swingResult.getStrikeCount()).isEqualTo(0);
        assertThat(swingResult.getBallCount()).isEqualTo(0);
    }
    @Test
    @DisplayName("복수 공 ,북수 공 비교 테스트 : 2볼 1 스트라이크")
    public void BALLS_2BALL_1STRIKE_TEST(){
        Balls targetBalls = new Balls(Arrays.asList(1,3,2));
        SwingResult swingResult = balls.match(targetBalls);
        assertThat(swingResult.getStrikeCount()).isEqualTo(1);
        assertThat(swingResult.getBallCount()).isEqualTo(2);

        targetBalls = new Balls(Arrays.asList(3,2,1));
        swingResult = balls.match(targetBalls);
        assertThat(swingResult.getStrikeCount()).isEqualTo(1);
        assertThat(swingResult.getBallCount()).isEqualTo(2);
    }
    @Test
    @DisplayName("복수 공 ,북수 공 비교 테스트 : 1볼 1 스트라이크")
    public void BALLS_1BALL_1STRIKE_TEST(){
        Balls targetBalls = new Balls(Arrays.asList(2,7,3));
        SwingResult swingResult = balls.match(targetBalls);
        assertThat(swingResult.getStrikeCount()).isEqualTo(1);
        assertThat(swingResult.getBallCount()).isEqualTo(1);
    }
    @Test
    @DisplayName("복수 공 ,북수 공 비교 테스트 : 3 스트라이크")
    public void BALLS_3STRIKE_TEST(){
        Balls targetBalls = new Balls(Arrays.asList(1,2,3));
        SwingResult swingResult = balls.match(targetBalls);
        assertThat(swingResult.getStrikeCount()).isEqualTo(3);
        assertThat(swingResult.getBallCount()).isEqualTo(0);
        assertThat(swingResult.isAllStrike()).isTrue();
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
