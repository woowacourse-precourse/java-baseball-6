package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameInputTest {

    @Test
    void baseBallNumber() {
        assertThrows(IllegalArgumentException.class, () -> GameInput.baseBallNumber("a"));
        assertThrows(IllegalArgumentException.class, () -> GameInput.baseBallNumber("!"));
        assertThrows(IllegalArgumentException.class, () -> GameInput.baseBallNumber("a1"));
        assertThrows(IllegalArgumentException.class, () -> GameInput.baseBallNumber("!1"));

        assertEquals(1, GameInput.baseBallNumber("1"));
        assertEquals(2, GameInput.baseBallNumber("2"));
    }

    @Test
    void afterGame() {
        assertThrows(IllegalArgumentException.class, () -> GameInput.afterGame("3"));
        assertThrows(IllegalArgumentException.class, () -> GameInput.afterGame("a"));
        assertThrows(IllegalArgumentException.class, () -> GameInput.afterGame("!"));
        assertThrows(IllegalArgumentException.class, () -> GameInput.afterGame("a1"));
        assertThrows(IllegalArgumentException.class, () -> GameInput.afterGame("!1"));

        assertEquals(1, GameInput.afterGame("1"));
        assertEquals(2, GameInput.afterGame("2"));
    }
}