package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallCounterTest {

    @AfterEach
    void resetBallCounter() {
        BallCounter.reset();
    }

    @DisplayName("볼을 카운트하면 개수가 1 증가한다.")
    @Test
    void countBall_Success() {
        // when
        BallCounter.countBall();

        // then
        assertThat(BallCounter.getCountOfBall()).isEqualTo(1);
    }

    @DisplayName("스트라이크를 카운트하면 개수가 1 증가한다.")
    @Test
    void countStrike_Success() {
        // when
        BallCounter.countStrike();

        // then
        assertThat(BallCounter.getCountOfStrike()).isEqualTo(1);
    }
}
