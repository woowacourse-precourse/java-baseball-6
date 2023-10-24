package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallCounterTest {

    private BallCounter ballCounter;

    @BeforeEach
    void setUp() {
        ballCounter = new BallCounter(0, 0);
    }

    @DisplayName("Strike와 Ball을 카운팅한다.")
    @Test
    void increaseStrikeCount() {
        ballCounter.increaseStrikeCount();
        ballCounter.increaseBallCount();

        Assertions.assertAll(
                () -> Assertions.assertEquals(1, ballCounter.getStrikeCount()),
                () -> Assertions.assertEquals(1, ballCounter.getBallCount())
        );
    }

    @DisplayName("상태가 낫싱인지 판단한다.")
    @Test
    void isNothing() {
        boolean actual = ballCounter.isNothing();

        Assertions.assertAll(
                () -> Assertions.assertTrue(actual)
        );
    }
}
