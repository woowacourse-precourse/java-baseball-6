package baseball.domain.ball;

import baseball.domain.status.BallStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

class BallTest {

    @Test
    @DisplayName("공의 숫자와 위치 정보를 부여할 수 있다.")
    void create() {
        Ball ball = new Ball(1, 1);
        assertThat(ball).isEqualTo(new Ball(1, 1));
    }

    @ParameterizedTest
    @MethodSource("ballAndBallStatus")
    @DisplayName("컴퓨터의 공과 플레이어의 공을 비교하여 결과를 알 수 있다.")
    void compare(Ball user, BallStatus expected) {
        Ball computer = new Ball(1, 1);
        BallStatus actual = computer.compare(user);

        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> ballAndBallStatus() {
        return Stream.of(
                arguments(new Ball(1, 1), BallStatus.STRIKE),
                arguments(new Ball(1, 3), BallStatus.BALL),
                arguments(new Ball(2, 1), BallStatus.NOTHING)
        );
    }
}