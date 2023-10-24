package baseball.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameRunnerTest {
    private final GameRunner gameRunner = new GameRunner();

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
