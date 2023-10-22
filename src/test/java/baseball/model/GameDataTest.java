package baseball.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.*;

public class GameDataTest {

    @Test
    public void testGameStatus() {
        GameData gameData = new GameData();
        assertTrue(gameData.isGameStatus());
        gameData.setGameStatus(false);
        assertFalse(gameData.isGameStatus());
    }

    @Test
    public void testStrikeCount() {
        GameData gameData = new GameData();
        assertEquals(3, gameData.getStrikeCount());
    }

    @Test
    public void testRandomNumbers() {
        GameData gameData = new GameData();
        List<Integer> randomNumbers = gameData.getComputerNumbers();
        assertNotNull(randomNumbers);
        assertEquals(3, randomNumbers.size());

        assertTrue(randomNumbers.stream().allMatch(number -> number >= 1 && number <= 9));

        HashSet<Integer> uniqueNumbers = new HashSet<>(randomNumbers);
        assertEquals(3, uniqueNumbers.size());
    }
}
