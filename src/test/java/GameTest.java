import static org.junit.jupiter.api.Assertions.*;

import baseball.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;

public class GameTest {

    private Game game;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

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

    @Test
    public void assertResetBallAndStrikeCntTest() {
        game.resetBallAndStrikeCnt();
        assertEquals(0, game.getBall());
        assertEquals(0, game.getStrike());
    }

    @Test
    public void assertGenerateRandomComputerAnswerTest() {
        game.generateRandomComputerAnser();
        int[] computerAnswer = game.getComputerAnswer();
        assertEquals(3, computerAnswer.length);
    }

    @Test
    public void testCalculateScore() {
        game.resetBallAndStrikeCnt();
        game.setPlayerAnswer(new int[3]);
        game.setComputerAnswer(123);
        game.calculateScore(426);
        assertEquals(1, game.getStrike());

        game.resetBallAndStrikeCnt();
        game.calculateScore(231);
        assertEquals(3, game.getBall());

        game.resetBallAndStrikeCnt();
        game.calculateScore(321);
        assertEquals(2, game.getBall());
        assertEquals(1, game.getStrike());

        game.resetBallAndStrikeCnt();
        game.calculateScore(333);
        assertEquals(2, game.getBall());
        assertEquals(1, game.getStrike());

        game.resetBallAndStrikeCnt();
        game.calculateScore(123);
        assertEquals(3, game.getStrike());


    }


}
