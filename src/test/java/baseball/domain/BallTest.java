package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class BallTest {

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
}