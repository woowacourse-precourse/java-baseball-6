package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserBallsTest {

    @DisplayName("중복되지 않는 3자리 숫자로 ball이 생성되어야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"234", "568", "897"})
    void getUserBallsTest(String input) {
        // given
        UserBalls userBalls = new UserBalls(input);

        // when
        String balls = userBalls.getUserBalls();

        // then
        assertThat(balls).isEqualTo(input);
    }

    @DisplayName("3자리 입력 값이 아닌 경우 IllegalArgumentException이 터져야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"2", "1234", "23", "345789"})
    void validateBallSizeTest(String input) {
        assertThatThrownBy(() -> new UserBalls(input))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("3자리 값만 입력해야 합니다.");
    }

    @DisplayName("입력 값이 숫자가 아닌 경우 IllegalArgumentException이 터져야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"2ab", "야구겜", "27o"})
    void validateNanTest(String input) {
        assertThatThrownBy(() -> new UserBalls(input))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해야 합니다.");
    }

    @DisplayName("입력 값의 각 자리 수 범위가 1~9가 아닌 경우 IllegalArgumentException이 터져야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"023", "230", "708"})
    void validateRangeTest(String input) {
        assertThatThrownBy(() -> new UserBalls(input))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("1~9사이의 값만 입력해야 합니다.");
    }

    @DisplayName("입력 값이 중복된 숫자일 경우 IllegalArgumentException이 터져야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"334", "272", "777", "588"})
    void validateDuplicateTest(String input) {
        assertThatThrownBy(() -> new UserBalls(input))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복되지 않은 값만 입력해야 합니다.");
    }
}