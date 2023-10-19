package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class BallTest {
    private Ball computer;

    @BeforeEach
    void setUp() {
        computer = new Ball(1, 1);
    }

    @Test
    @DisplayName("공의 숫자와 위치 정보를 부여할 수 있다.")
    void create() {
        Ball ball = new Ball(1, 1);
        assertThat(ball).isEqualTo(new Ball(1, 1));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    @DisplayName("공의 숫자가 1부터 9까지의 범위를 벗어나면 예외가 발생한다.")
    void invalidNumber(int ballNumber) {
        assertThatThrownBy(() -> new Ball(ballNumber, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공의 숫자는 1에서 9사이의 값이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 4})
    @DisplayName("공의 위치가 1부터 3까지의 범위를 벗어나면 예외가 발생한다.")
    void invalidPosition(int position) {
        assertThatThrownBy(() -> new Ball(1, position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공의 위치는 1에서 3사이의 값이어야 합니다.");
    }

    @Test
    @DisplayName("컴퓨터의 공과 플레이어의 공을 비교하여 결과를 알 수 있다.")
    void compare_strike() {
        Ball user = new Ball(1, 1);
        BallStatus result = computer.compare(user);

        assertThat(result).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("컴퓨터의 공과 플레이어의 공을 비교하여 결과를 알 수 있다.")
    void compare_ball() {
        Ball user = new Ball(1, 3);
        BallStatus result = computer.compare(user);

        assertThat(result).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("컴퓨터의 공과 플레이어의 공을 비교하여 결과를 알 수 있다.")
    void compare_nothing() {
        Ball user = new Ball(2, 1);
        BallStatus result = computer.compare(user);

        assertThat(result).isEqualTo(BallStatus.NOTHING);
    }
}