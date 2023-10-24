package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.ball.Ball;
import baseball.ball.BallStatus;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BallsTest {
    Balls answers;
    @BeforeEach
    void setUp(){
        answers = new Balls(Arrays.asList(1,2,3));
    }
    @Test
    void strike() {
        BallStatus ballStatus = answers.play(new Ball(1,1));
        assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
    }
    @Test
    void ball() {
        BallStatus ballStatus = answers.play(new Ball(2,1));
        assertThat(ballStatus).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        BallStatus ballStatus = answers.play(new Ball(1,4));
        assertThat(ballStatus).isEqualTo(BallStatus.NOTHING);
    }
}
