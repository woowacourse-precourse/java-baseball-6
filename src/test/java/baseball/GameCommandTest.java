package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameCommandTest {

    @DisplayName("주어진 숫자로 명령어 상수를 불러올 수 있다.")
    @Test
    void from() {
        GameCommand restartCommand = GameCommand.from(1);
        GameCommand endCommand = GameCommand.from(2);

        assertThat(restartCommand.isRestart()).isTrue();
        assertThat(endCommand.isRestart()).isFalse();
    }

    @DisplayName("주어진 숫자가 정해진 명렁어 상수와 일치하는 것이 없는 경우, 상수를 불러올 수 없다.")
    @Test
    void checkInvalidCommandValue() {
        assertThatThrownBy(() -> GameCommand.from(3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효한 커맨드를 입력해주세요.");
    }
}
