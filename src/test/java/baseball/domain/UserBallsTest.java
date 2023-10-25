package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserBallsTest {

    @DisplayName("3자리 1-9 사이의 숫자가 입력되면 Balls가 생성된다")
    @ParameterizedTest
    @ValueSource(strings = {"123", "542", "193"})
    void from(String givenValue) {
        assertDoesNotThrow(() -> UserBalls.from(givenValue));
    }

    @DisplayName("숫자가 아닌 문자, 3자리가 아닌 숫자, 중복된 숫자, 0을 포함한 숫자가 입력되면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"aㅇ1", "$", "", "1", "12", "112", "902"})
    void invalid_from(String givenValue) {
        assertThatThrownBy(() -> UserBalls.from(givenValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("불변의 Ball 리스트가 반환된다")
    @Test
    void balls() {
        UserBalls userBalls = UserBalls.from("123");
        List<Ball> balls = userBalls.balls();

        assertThatThrownBy(() -> balls.add(0, Ball.from("4")))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("주어진 index의 Ball이 반환된다")
    @Test
    void ballAt() {
        UserBalls userBalls = UserBalls.from("123");
        assertThat(userBalls.ballAt(0)).isEqualTo(Ball.from("1"));
    }

}
