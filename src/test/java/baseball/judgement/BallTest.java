package baseball.judgement;

import baseball.computer.judgement.Ball;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BallTest {
    @Test
    void equals() {
        Ball ball1 = new Ball(1, 1);
        Ball ball2 = new Ball(1, 1);

        assertThat(ball1).isEqualTo(ball2);
    }
}