package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallCounterTest {

    private static final int DIGIT_NUMBER = 3;

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
        Assertions.assertThat(BallCounter.getCountOfBall()).isEqualTo(1);
    }

    @DisplayName("스트라이크를 카운트하면 개수가 1 증가한다.")
    @Test
    void countStrike_Success() {
        // when
        BallCounter.countStrike();

        // then
        Assertions.assertThat(BallCounter.getCountOfStrike()).isEqualTo(1);
    }

    @DisplayName("스트라이크 개수가 지정 자릿수와 일치하는 경우 true를 반환한다.")
    @Test
    void isAllStrike_True() {
        // given
        for (int i = 0; i < DIGIT_NUMBER; i++) {
            BallCounter.countStrike();
        }

        // when
        boolean allStrike = BallCounter.isAllStrike(DIGIT_NUMBER);

        // then
        Assertions.assertThat(allStrike).isTrue();
    }
}
