package baseball;

import baseball.model.BallCount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BallCountTest {
    @Test
    void 볼카운트_결정() {
        Assertions.assertEquals(BallCount.STRIKE, BallCount.decideBallCount(true, true));
        Assertions.assertEquals(BallCount.BALL, BallCount.decideBallCount(true, false));
        Assertions.assertEquals(BallCount.NOTHING, BallCount.decideBallCount(false, false));
    }

    @Test
    void 올바른_볼_스트라이크_낫싱_반환() {
        Assertions.assertEquals("스트라이크", BallCount.STRIKE.getBaseballjudgment());
        Assertions.assertEquals("볼", BallCount.BALL.getBaseballjudgment());
        Assertions.assertEquals("낫싱", BallCount.NOTHING.getBaseballjudgment());

    }
}

