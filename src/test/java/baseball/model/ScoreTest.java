package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.score.Score;
import org.junit.jupiter.api.Test;

class ScoreTest {
    @Test
    void isThreeStrike_3스트라이크() {
        // given
        Score score = new Score(0, 3);

        // when
        boolean result = score.isThreeStrike();

        // then
        assertThat(result).isEqualTo(true);
    }

    @Test
    void isThreeStrike_3스트라이크_아님() {
        // given
        Score score = new Score(0, 1);

        // when
        boolean result = score.isThreeStrike();

        // then
        assertThat(result).isEqualTo(false);
    }
}
