package baseball.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameTest {

    private final BaseballGame baseballGame = new BaseballGame();

    @Test
    @DisplayName("스트라이크 수_1")
    void countStrike() {
        baseballGame.setComputer("123");
        baseballGame.setUser("123");

        assertThat(baseballGame.countStrike()).isEqualTo(3);

    }

    @Test
    @DisplayName("스트라이크 수_2")
    void countStrike2() {
        baseballGame.setComputer("456");
        baseballGame.setUser("236");

        assertThat(baseballGame.countStrike()).isEqualTo(1);
    }
}