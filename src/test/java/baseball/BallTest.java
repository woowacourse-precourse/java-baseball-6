package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.ball.Ball;
import baseball.ball.BallStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallTest {
    private Ball com;
    @BeforeEach
    void setUP(){
        com = new Ball(1,4);
    }
    @Test
    @DisplayName("야구 숫자 1,9 검증")
    void nothing_test() {
        assertThat(com.play(new Ball(2,5))).isEqualTo(BallStatus.NOTHING);
    }
    @Test
    @DisplayName("야구 숫자 1,9 검증")
    void ball_test() {
        assertThat(com.play(new Ball(2,4))).isEqualTo(BallStatus.BALL);
    }
    @Test
    @DisplayName("야구 숫자 1,9 검증")
    void strike_test() {
        assertThat(com.play(new Ball(1,4))).isEqualTo(BallStatus.STRIKE);
    }
}
