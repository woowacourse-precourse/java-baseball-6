package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {

    @Test
    @DisplayName("3스트라이크이면 정답이다")
    void recognizeCorrectAnswer() {
        GameResult result = new GameResult(0, 3);

        assertThat(result.isCorrect()).isTrue();
    }

    @Test
    @DisplayName("3스트라이크가 아니면 정답이 아니다")
    void recognizeIncorrectAnswer() {
        GameResult result = new GameResult(1, 1);

        assertThat(result.isCorrect()).isFalse();
    }
}
