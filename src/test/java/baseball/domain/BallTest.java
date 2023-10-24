package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BallTest {

    @Test
    void 비교_확인() {
        Ball ball = new Ball(5);
        Ball ball2 = new Ball(5);

        assertEquals(ball, ball2);
    }


    @Test
    void 숫자_범위_벗어난_경우() {
        assertThrows(IllegalArgumentException.class,
                () -> new Ball(100));
    }

}