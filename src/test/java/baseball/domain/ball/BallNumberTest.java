package baseball.domain.ball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class BallNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 9})
    @DisplayName("공의 숫자 값을 부여할 수 있다.")
    void createBallNumber(int number) {
        BallNumber ballNumber = new BallNumber(number);
        assertThat(ballNumber).isEqualTo(new BallNumber(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    @DisplayName("공의 숫자가 1부터 9까지의 범위를 벗어나면 예외가 발생한다.")
    void invalidBallNumber(int ballNumber) {
        assertThatThrownBy(() -> new BallNumber(ballNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공의 숫자는 1에서 9사이의 값이어야 합니다.");
    }
}