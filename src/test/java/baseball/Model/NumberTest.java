package baseball.Model;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class NumberTest {

    @Test
    void 스트라이크체크() {
        Number computerNumber = new Number(1, 0);
        Number playerNumber = new Number(1, 0);
        assertTrue(computerNumber.checkStrike(playerNumber));
    }

    @Test
    void 볼체크() {
        Number computerNumber = new Number(1, 0);
        Number playerNumber = new Number(1, 1);
        assertTrue(computerNumber.checkBall(playerNumber));
    }

    @Test
    void 숫자범위예외발생체크() {
        assertThrows(IllegalArgumentException.class, () -> new Number(0, 1));
        assertThrows(IllegalArgumentException.class, () -> new Number(10, 1));
    }

    @Test
    void 위치범위예외발생체크() {
        assertThrows(IllegalArgumentException.class, () -> new Number(1, -1));
        assertThrows(IllegalArgumentException.class, () -> new Number(1, 3));
    }

}
