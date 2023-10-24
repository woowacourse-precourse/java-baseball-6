package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.common.config.BaseballMessageConst;
import org.junit.jupiter.api.Test;

class BallTest {

    @Test
    void 정상으로_Ball_enum이_생성() {
        assertEquals(Ball.ZERO, Ball.of(0));
        assertEquals(Ball.ONE, Ball.of(1));
        assertEquals(Ball.TWO, Ball.of(2));
        assertEquals(Ball.THREE, Ball.of(3));
    }

    @Test
    void 범위에_벗어나면_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Ball.of(4), BaseballMessageConst.OUT_OF_RANGE_BALL_ERROR);
        assertThrows(IllegalArgumentException.class, () -> Ball.of(-1), BaseballMessageConst.OUT_OF_RANGE_BALL_ERROR);
    }

}