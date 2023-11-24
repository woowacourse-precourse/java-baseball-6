package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameStatusTest {

    @DisplayName("게임 상태를 구한다.")
    @CsvSource({"1, RESTART", "2, QUIT"})
    @ParameterizedTest
    void findGameStatus(String command, GameStatus gameStatus) {
        GameStatus result = GameStatus.find(command);
        assertThat(result).isEqualTo(gameStatus);
    }

    @DisplayName("유효하지 않은 명령일 경우 예외가 발생한다.")
    @ValueSource(strings = "0, 3, 4")
    @ParameterizedTest
    void findGameStatusEx(String command) {
        assertThatThrownBy(() -> GameStatus.find(command))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
