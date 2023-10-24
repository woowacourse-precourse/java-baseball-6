package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.model.BallCount;
import org.junit.jupiter.api.Test;

public class BallCountTest {
    @Test
    void 볼_판정_테스트() {
        BallCount ballCount = BallCount.judge(true, false);
        assertEquals(ballCount, BallCount.BALL);
    }

    @Test
    void 스트라이크_판정_테스트() {
        BallCount ballCount = BallCount.judge(true, true);
        assertEquals(ballCount, BallCount.STRIKE);
    }

    @Test
    void 낫싱_판정_테스트() {
        BallCount ballCount = BallCount.judge(false, false);
        assertEquals(ballCount, BallCount.NOTHING);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    BallCount ballCount = BallCount.judge(false, true);
                })
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
