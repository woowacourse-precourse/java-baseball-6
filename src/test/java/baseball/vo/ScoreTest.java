package baseball.vo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScoreTest {

    @Test
    @DisplayName("score의 ball은 증가시킨 strike만큼 감소한다.")
    void decreaseBallAsIncreaseStrike() {
        //given
        Score score = new Score(2);
        //when
        score.increaseStrike(2);
        //then
        assertThat(score.getBall()).isZero();
        assertThat(score.getStrike()).isEqualTo(2);
    }
}