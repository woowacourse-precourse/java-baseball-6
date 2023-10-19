package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameStatusTest {
    @DisplayName("command 를 입력받아 게임 상태를 반환한다")
    @ParameterizedTest
    @CsvSource({"1, RESTART", "2, EXIT"})
    void GetGameStatusFromCommand(int command, GameStatus expected) {
        GameStatus actual = GameStatus.from(command);

        assertThat(actual).isEqualTo(expected);
    }
}
