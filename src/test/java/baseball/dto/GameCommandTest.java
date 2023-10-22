package baseball.dto;

import baseball.constants.Constants;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameCommandTest {

    @Test
    @DisplayName("잘못된 입력에 대한 예외처리")
    void fromInvalidInputCommand() {
        Assertions.assertThatThrownBy(() -> GameCommand.fromInputCommand("invalid"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.ERROR_INVALID_COMMAND);
    }

    @Test
    @DisplayName("입력에 대한 처리")
    void fromInputCommand() {
        assertThat(GameCommand.fromInputCommand("1")).isEqualTo(GameCommand.RESTART);
        assertThat(GameCommand.fromInputCommand("2")).isEqualTo(GameCommand.END);
    }
}