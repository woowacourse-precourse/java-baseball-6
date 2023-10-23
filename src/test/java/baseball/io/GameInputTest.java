package baseball.io;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameInputTest {

    @Test
    void baseBallNumber() {
        assertThrows(IllegalArgumentException.class, () -> GameInput.baseBallNumber("a"));
        assertThrows(IllegalArgumentException.class, () -> GameInput.baseBallNumber("12a"));
        assertThrows(IllegalArgumentException.class, () -> GameInput.baseBallNumber("!"));
        assertEquals(123, GameInput.baseBallNumber("123"));
    }

    @Test
    void afterGame() {
        assertThrows(IllegalArgumentException.class, () -> GameInput.afterGame("3"));
        assertThrows(IllegalArgumentException.class, () -> GameInput.afterGame("3a"));
        assertThrows(IllegalArgumentException.class, () -> GameInput.afterGame("a"));
        assertThrows(IllegalArgumentException.class, () -> GameInput.afterGame("!"));
    }
}