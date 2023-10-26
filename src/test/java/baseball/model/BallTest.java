package baseball.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BallTest {

    @Test
    void exceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> new Ball(-1));
    }

    @Test
    void equalsTest() {
        Ball ball1 = new Ball(1);
        Ball ball11 = new Ball(1);
        Ball ball2 = new Ball(2);

        assertTrue(ball1.equals(ball11));
        assertFalse(ball1.equals(ball2));
    }
}