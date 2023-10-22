package baseball.service;

import baseball.constants.Constants;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTest {
    private final Game game = new Game();
    private final GameRunner gameRunner = new GameRunner();

    @DisplayName("유저 인풋 에러 발생상황 확인")
    @ParameterizedTest
    @CsvSource({"1234", ",", "\n,", "1s2"})
    void getInvalidUserNums(String userInput) {
        assertThatThrownBy(() -> game.getUserNums(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.ERROR_INVALID_NUMBER);

    }

    @Test
    @DisplayName("유저 인풋 상황 확인")
    void getValidUserNums() {
        List<Integer> userNums = game.getUserNums("123");
        Assertions.assertThat(userNums).isEqualTo(List.of(1, 2, 3));
    }

    @Test
    @DisplayName("재실행 하는경우")
    void isReplay() {
        boolean replay = gameRunner.isReplay("1");
        Assertions.assertThat(replay).isTrue();
    }

    @Test
    @DisplayName("재실행 하지 않는경우")
    void isNotReplay() {
        boolean replay = gameRunner.isReplay("2");
        Assertions.assertThat(replay).isFalse();
    }
}