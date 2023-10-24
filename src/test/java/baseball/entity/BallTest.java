package baseball.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallTest {

    @DisplayName("공을 생성할 수 있다.")
    @Test
    void create() {
        Ball ball = Ball.of(1, 1);
        Ball otherBall = Ball.of(1, 1);

        assertThat(ball).isEqualTo(otherBall);
    }

    @DisplayName("공이 가질 수 있는 숫자의 범위는 1부터 9사이의 수이다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void checkNumberInRange(int number) {
        assertThatThrownBy(() -> Ball.of(number, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공이 가질 수 있는 숫자는 1~9 중 하나입니다.");
    }

    @DisplayName("공이 가질 수 있는 위치의 범위는 1부터 3사이의 수이다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 4})
    void checkPositionInRange(int position) {
        assertThatThrownBy(() -> Ball.of(1, position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공이 가질 수 있는 위치는 1~3 중 하나입니다.");
    }

    @DisplayName("알 수 없는 공(null)과 비교할 수 없다.")
    @Test
    void evaluateWithNull() {
        Ball answerBall = Ball.of(1, 1);

        assertThatThrownBy(() -> answerBall.evaluate(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("알 수 없는 공(null)과는 비교할 수 없습니다.");
    }

    @DisplayName("정답 공과 숫자만 일치하는 경우 볼이다.")
    @Test
    void evaluateBall() {
        Ball answerBall = Ball.of(1, 1);
        Ball ball = Ball.of(1, 2);

        BallStatus result = answerBall.evaluate(ball);

        assertThat(result.isBall()).isTrue();
    }

    @DisplayName("정답 공과 숫자와 위치가 일치하는 경우 스트라이크이다.")
    @Test
    void evaluateStrike() {
        Ball answerBall = Ball.of(1, 1);
        Ball ball = Ball.of(1, 1);

        BallStatus result = answerBall.evaluate(ball);

        assertThat(result.isStrike()).isTrue();
    }

    @DisplayName("정답 공과 숫자와 위치가 모두 다르면 아무것도 아니다.")
    @Test
    void evaluateNothing() {
        Ball answerBall = Ball.of(3, 1);
        Ball ball = Ball.of(1, 2);

        BallStatus result = answerBall.evaluate(ball);

        assertThat(result.isNothing()).isTrue();
    }
}
