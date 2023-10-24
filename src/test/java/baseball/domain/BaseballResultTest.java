package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.common.config.BaseballMessageConst;
import org.junit.jupiter.api.Test;

class BaseballResultTest {
    @Test
    void 게임종료() {
        BaseballResult baseballResult1 = BaseballResult.from(1, 2);
        assertFalse(baseballResult1.isGameDone());
        BaseballResult baseballResult2 = BaseballResult.from(0, 3);
        assertTrue(baseballResult2.isGameDone());
    }

    @Test
    void 문자열_생성_볼_스트라이크() {
        BaseballResult baseballResult = BaseballResult.from(1, 2);
        String expected = String.format(BaseballMessageConst.BALL_MESSAGE, 1) + " " + String.format(
                BaseballMessageConst.STRIKE_MESSAGE, 2);
        assertEquals(expected, baseballResult.toString());
    }

    @Test
    void 문자열_생성_낫싱() {
        BaseballResult baseballResult = BaseballResult.from(0, 0);
        String expected = BaseballMessageConst.NOTHING_MESSAGE;
        assertEquals(expected, baseballResult.toString());
    }
}