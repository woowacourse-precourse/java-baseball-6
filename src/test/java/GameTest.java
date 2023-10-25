import static org.junit.jupiter.api.Assertions.*;

import baseball.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {

    private Game game;

    @BeforeEach
    public void setUp() {
        game = new Game();
    }

    @Test
    public void assertCheckValidNumberTest() {
        assertTrue(game.checkValidNumber(123));
        assertFalse(game.checkValidNumber(100));
        assertFalse(game.checkValidNumber(012));
    }

    @Test
    public void assertConvertStringToIntegerTest() {
        assertEquals(123, game.convertStringToInteger("123"));
        assertThrows(IllegalArgumentException.class, () -> game.convertStringToInteger("ABDDDDD"));
        assertThrows(IllegalArgumentException.class, () -> game.convertStringToInteger("123456"));
    }


}
