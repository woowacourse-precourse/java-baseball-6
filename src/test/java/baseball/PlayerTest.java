package baseball;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    private static Player player;

    @BeforeAll
    public static void setup(){
        player = new Player();
    }

    @Test
    public void testNullBall(){
        assertThrows(IllegalArgumentException.class, () -> {
            player.inputBall(null);
        });
    }

    @Test
    public void testLongBall(){
        assertThrows(IllegalArgumentException.class, () -> {
            player.inputBall("1234");
        });
    }

    @Test
    public void testZeroBall(){
        assertThrows(IllegalArgumentException.class, () -> {
            player.inputBall("102");
        });
    }

    @Test
    public void testDuplicateBall(){
        assertThrows(IllegalArgumentException.class, () -> {
            player.inputBall("112");
        });
    }

    @Test
    public void testValidBall(){
        assertEquals("123", player.inputBall("123"));
    }

    @Test
    public void testNullFlag(){
        assertThrows(IllegalArgumentException.class, () -> {
            player.conformGameRestart(null);
        });
    }

    @Test
    public void testMinusFlag(){
        assertThrows(IllegalArgumentException.class, () -> {
            player.conformGameRestart("-1");
        });
    }

    @Test
    public void testOutRangeFlag(){
        assertThrows(IllegalArgumentException.class, () -> {
            player.conformGameRestart("3");
        });
    }

    @Test
    public void testValidFlag(){
        assertTrue(player.conformGameRestart("1"));
        assertFalse(player.conformGameRestart("2"));
    }
}
