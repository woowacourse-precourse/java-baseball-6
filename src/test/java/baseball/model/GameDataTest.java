package baseball.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.*;

public class GameDataTest {
    @Test
    public void testRandomNumbers() {
        GameData.UPDATE_RANDOM_NUMBERS();

        List<Integer> randomNumbers = GameData.RANDOM_NUMBERS;

        assertNotNull(randomNumbers);
        assertEquals(3, randomNumbers.size());

        assertTrue(randomNumbers.stream().allMatch(number -> number >= 1 && number <= 9));

        HashSet<Integer> uniqueNumbers = new HashSet<>(randomNumbers);
        assertEquals(3, uniqueNumbers.size());
    }
}