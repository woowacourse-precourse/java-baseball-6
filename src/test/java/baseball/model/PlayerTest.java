package baseball.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player();
    }

    @Test
    void testCreatePlayerNumber() {
        player.createPlayerNumber("123");
        assertEquals(List.of(1, 2, 3), player.getPlayerNumber());

        player.createPlayerNumber("456");
        assertEquals(List.of(4, 5, 6), player.getPlayerNumber());
    }

    @Test
    void testCreatePlayerNumberWithInvalidInput() {
        player.createPlayerNumber("112");
        assertEquals(List.of(1, 1, 2), player.getPlayerNumber());

        player.createPlayerNumber("12");
        assertEquals(List.of(1, 2), player.getPlayerNumber());

        player.createPlayerNumber("1234");
        assertEquals(List.of(1, 2, 3, 4), player.getPlayerNumber());
    }
}
