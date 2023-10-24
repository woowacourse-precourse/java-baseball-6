package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BallTest {
    @Test
    void 같은_볼_비교_테스트() {
        Ball ball1 = new Ball(4);
        Ball ball2 = new Ball(4);
        Assertions.assertEquals(ball1, ball2);
    }
}