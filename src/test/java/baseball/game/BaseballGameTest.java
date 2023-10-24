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

    @Test
    @DisplayName("볼 수")
    void countBall() {
        baseballGame.setComputer("123");
        baseballGame.setUser("345");

        assertThat(baseballGame.countBall()).isEqualTo(1);

    }

    @Test
    @DisplayName("볼 수_스트라이크는 볼이 아니다")
    void countBall2() {
        baseballGame.setComputer("456");
        baseballGame.setUser("456");

        assertThat(baseballGame.countBall()).isEqualTo(0);
    }
}