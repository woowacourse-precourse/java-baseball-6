package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static baseball.domain.GameProcessDecider.GAME_END;
import static baseball.domain.GameProcessDecider.GAME_RESTART;
import static baseball.exception.ExceptionMessage.GameProcessCommandException.INVALID_COMMAND;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameProcessDeciderTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 3, 4})
    @DisplayName("재시작[1], 종료[2] 이외의 Command를 입력하면 예외가 발생한다")
    void throwExceptionByInvalidCommand(final int command) {
        assertThatThrownBy(() -> GameProcessDecider.getDecider(command))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_COMMAND.message);
    }

    @Test
    @DisplayName("게임 재시작[1] Decider를 선택한다")
    void selectGameRestart() {
        // when
        final GameProcessDecider decider = GameProcessDecider.getDecider(1);

        // then
        assertThat(decider).isEqualTo(GAME_RESTART);
    }

    @Test
    @DisplayName("게임 종료[2] Decider를 선택한다")
    void selectGameEnd() {
        // when
        final GameProcessDecider decider = GameProcessDecider.getDecider(2);

        // then
        assertThat(decider).isEqualTo(GAME_END);
    }
}
