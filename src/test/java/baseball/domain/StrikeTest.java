package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class StrikeTest {
    @Test
    void 정상으로_Strike_enum이_생성() {
        assertEquals(Strike.ZERO, Strike.of(0));
        assertEquals(Strike.ONE, Strike.of(1));
        assertEquals(Strike.TWO, Strike.of(2));
        assertEquals(Strike.THREE, Strike.of(3));
    }

    @Test
    void 범위에_벗어나면_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Strike.of(4), BaseballMessageConst.OUT_OF_RANGE_BALL_ERROR);
        assertThrows(IllegalArgumentException.class, () -> Strike.of(-1), BaseballMessageConst.OUT_OF_RANGE_BALL_ERROR);
    }

}