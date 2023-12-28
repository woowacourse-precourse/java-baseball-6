package baseball.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BallTest {

    @Test
    void numberSizeTest() {
        Assertions.assertThatThrownBy(() -> new Ball(List.of(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkStrikeTest() {
        Ball answerBall = new Ball(List.of(1, 2, 3));
        Ball playerBall = new Ball(List.of(1, 2, 3));

        Assertions.assertThat(answerBall.checkStrike(playerBall))
                .isEqualTo(3);
    }

    @Test
    void checkBallTest() {
        Ball answerBall = new Ball(List.of(3, 1, 4));
        Ball playerBall = new Ball(List.of(1, 2, 3));

        Assertions.assertThat(answerBall.checkBall(playerBall))
                .isEqualTo(2);
    }

    @Test
    void checkStrikeOutTest() {
        Ball answerBall = new Ball(List.of(1, 2, 3));
        Ball playerBall = new Ball(List.of(1, 2, 3));

        Assertions.assertThat(answerBall.checkStrikeOut(playerBall))
                .isEqualTo(true);
    }
}
