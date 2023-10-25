package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.domain.Baseball;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseballTest {

    private Baseball baseball;

    @BeforeEach
    public void setUp() {
        baseball = new Baseball(Arrays.asList(1, 2, 3));
    }

    @Test
    public void testCountStrikes() {
        int result = baseball.countStrikes(Arrays.asList(1, 5, 3));
        assertEquals(2, result); // 1st and 3rd positions match.
    }

    @Test
    public void testCountBalls() {
        int result = baseball.countBalls(Arrays.asList(3, 1, 2));
        assertEquals(3, result); // All numbers are present but in different positions.
    }

    @Test
    public void testIsGameWon() {
        assertFalse(baseball.isGameWon(2)); // Only 2 strikes.
        assertTrue(baseball.isGameWon(3));  // 3 strikes, game won.
    }
}