package baseball.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BallNumberTest {

    @Test
    void exceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> new BallNumber(-1));
    }

    @Test
    void equalsTest() {
        BallNumber ballNumber1 = new BallNumber(1);
        BallNumber ballNumber11 = new BallNumber(1);
        BallNumber ballNumber2 = new BallNumber(2);

        assertTrue(ballNumber1.equals(ballNumber11));
        assertFalse(ballNumber1.equals(ballNumber2));
    }
}