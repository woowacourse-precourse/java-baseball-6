package baseball.dto;

import baseball.constants.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameCommandTest {

    @DisplayName("잘못된 입력에 대한 예외처리")
    @ParameterizedTest
    @CsvSource({"test", "3", ","})
    void fromInvalidInputCommand(String input) {
        assertThatThrownBy(() -> GameCommand.fromInputCommand(input))
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