package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class BallsTest {
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
