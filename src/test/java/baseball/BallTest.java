package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallTest {
    static Ball ball;

    @BeforeAll
    static void setUp() {
        ball = new Ball(3, 2);
    }

    @DisplayName("스트라이크 결과를 정확히 판단하는지 확인합니다.")
    @Test
    void isStrike() {
        Ball other = new Ball(3, 2);

        assertThat(ball.isStrike(other))
                .isTrue();
    }

    @DisplayName("볼 결과를 정확히 판단하는지 확인합니다.")
    @ParameterizedTest(name = "주어진 공의 위치가 2일때, 값은 동일하고 위치가 {0}인 경우")
    @ValueSource(ints = {0, 1})
    void isBall(int location) {
        Ball other = new Ball(3, location);

        assertThat(ball.isBall(other))
                .isTrue();
    }
}