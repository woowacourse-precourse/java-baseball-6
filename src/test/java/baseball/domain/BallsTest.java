package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BallsTest {
    @Test
    void play_nothing() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        List<Integer> userNumber = new ArrayList<>(Arrays.asList(5, 7, 9));
        PlayResult result = answers.play(new Balls(userNumber));
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    void play_1strike_1ball() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        List<Integer> userNumber = new ArrayList<>(Arrays.asList(1, 7, 2));
        PlayResult result = answers.play(new Balls(userNumber));
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    void play_3strike() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        List<Integer> userNumber = new ArrayList<>(Arrays.asList(1, 2, 3));
        PlayResult result = answers.play(new Balls(userNumber));
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.isGameEnd()).isTrue();
    }

    @Test
    void strike() {
        Balls computer = new Balls(Arrays.asList(1, 5, 7));
        BallStatus status = computer.play(new Ball(1, 1));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        Balls computer = new Balls(Arrays.asList(1, 5, 7));
        BallStatus status = computer.play(new Ball(1, 5));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        Balls computer = new Balls(Arrays.asList(1, 5, 7));
        BallStatus status = computer.play(new Ball(1, 4));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
