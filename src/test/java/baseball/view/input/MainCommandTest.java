package baseball.view.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MainCommandTest {

    @DisplayName("입력된 값에 따라 새로운 게임을 진행할지 여부를 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:false"}, delimiter = ':')
    void shouldStartNewGame(String command, boolean expected) {
        assertThat(MainCommand.shouldStartNewGame(command)).isEqualTo(expected);
    }

    @DisplayName("잘못된 값이 전달되면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"0", "3", "11", "22"})
    void invalid_shouldStartNewGame(String command) {
        assertThatThrownBy(() -> MainCommand.shouldStartNewGame(command))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
