package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;

public class GameProcessStatusTest {
    @Test
    @DisplayName("게임이 진행중인 상태인지 확인한다")
    void isGameInProgress() {
        assertAll(
                () -> Assertions.assertThat(GameProcessStatus.GAME_RUNNING.isGameInProgress()).isTrue(),
                () -> Assertions.assertThat(GameProcessStatus.GAME_RESTART.isGameInProgress()).isTrue(),
                () -> Assertions.assertThat(GameProcessStatus.GAME_TERMINATE.isGameInProgress()).isFalse()
        );
    }
}
