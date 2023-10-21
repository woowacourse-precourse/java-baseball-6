package baseball.domain.game;

import baseball.domain.ball.Ball;
import baseball.domain.status.BallStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BallsTest {

    @Test
    @DisplayName("공들은 1부터 9까지 서로 다른 수로 이루어진 3개의 공으로 이루어져 있다.")
    void create() {
        List<Integer> numbers = List.of(1, 2, 3);
        Balls balls = new Balls(numbers);

        assertThat(balls).isEqualTo(new Balls(numbers));
    }

    @Test
    @DisplayName("공들의 총 개수가 3개가 아니라면 예외가 발생한다.")
    void invalidSize() {
        assertThatThrownBy(() -> new Balls(List.of(1, 2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공들은 3개의 공으로 이루어져야 합니다.");
    }

    @Test
    @DisplayName("공들의 숫자 중 중복되는 수가 있다면 예외가 발생한다.")
    void hasDuplicatedNumber() {
        assertThatThrownBy(() -> new Balls(List.of(1, 2, 2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공들의 숫자는 중복될 수 없습니다.");
    }

    @ParameterizedTest
    @MethodSource("ballAndBallStatus")
    @DisplayName("컴퓨터의 공들과 플레이어의 공 하나를 비교하여 결과를 알 수 있다.")
    void compare(Ball user, BallStatus expected) {
        Balls computers = new Balls(List.of(1, 2, 3));
        BallStatus actual = computers.judgeBallStatusOf(user);

        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> ballAndBallStatus() {
        return Stream.of(
                arguments(new Ball(1, 1), BallStatus.STRIKE),
                arguments(new Ball(1, 3), BallStatus.BALL),
                arguments(new Ball(4, 1), BallStatus.NOTHING)
        );
    }
}