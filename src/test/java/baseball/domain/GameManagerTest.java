package baseball.domain;

import static baseball.utils.ErrorMessage.COMMAND_CODE_IS_INVALID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameManagerTest {

    @DisplayName("1이 들어오면 게임 재시작(true)를 리턴한다")
    @Test
    void gameRetry() {
        assertThat(new GameManager().isGameRetry("1"))
                .isTrue();
    }

    @DisplayName("0이 들어오면 게임 종료(false)를 리턴한다")
    @Test
    void gameEnd() {
        assertThat(new GameManager().isGameRetry("2"))
                .isFalse();
    }

    @ParameterizedTest
    @DisplayName("1 혹은 2가 아닌 다른 숫자코드가 들어오면 예외가 발생한다.")
    @ValueSource(strings = {"0", "-1", "01", "3"})
    void invalidCommandCode(String input) {
        assertThatThrownBy(() -> new GameManager().isGameRetry(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(COMMAND_CODE_IS_INVALID);
    }
}