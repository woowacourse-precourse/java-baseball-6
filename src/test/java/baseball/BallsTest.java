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
    void play_nothing() {
        PlayResult result = answers.play(Arrays.asList(4,5,6));
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }
    @Test
    void play_3Strike() {
        PlayResult result = answers.play(Arrays.asList(1,2,3));
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.isGameEnd()).isTrue();
    }
    @Test
    void play_1Strike_1ball() {
        PlayResult played = answers.play(Arrays.asList(1,4,2));
        assertThat(played.getStrike()).isEqualTo(1);
        assertThat(played.getBall()).isEqualTo(1);
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
