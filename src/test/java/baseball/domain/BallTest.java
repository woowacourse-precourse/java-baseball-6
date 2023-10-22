package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class BallTest {

    @DisplayName("볼의 범위가 1~9가 아니라면 예외발")
    @Test
    void createBall() {
        assertThatThrownBy(() -> new Ball(0, 1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Ball(10, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("다른 ball과 비교해서 스트라이크인지 확인")
    @Test
    void isStrike() {
        // given
        Ball ball = new Ball(1, 2);

        // when
        boolean result = ball.isStrike(new Ball(1, 2));

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("다른 ball과 비교해서 볼인지 확인")
    @Test
    void isBall() {
        // given
        Ball ball = new Ball(1, 2);

        // when
        boolean result = ball.isBall(new Ball(1, 0));

        // then
        assertThat(result).isTrue();
    }
}