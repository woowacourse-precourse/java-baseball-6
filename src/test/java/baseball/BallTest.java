package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallTest {

    @DisplayName("스트라이크 결과를 정확히 판단하는지 확인합니다.")
    @Test
    void isStrike() {
        Ball ball = new Ball(3, 2);
        Ball other = new Ball(3, 2);

        assertThat(ball.isStrike(other))
                .isTrue();
    }

    @DisplayName("볼 결과를 정확히 판단하는지 확인합니다.")
    @Test
    void isBall() {
        Ball ball = new Ball(3, 1);
        Ball other = new Ball(3, 2);

        assertThat(ball.isBall(other))
                .isTrue();
    }
}