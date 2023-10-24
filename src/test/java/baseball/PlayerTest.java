package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {
    @Test
    void getNumber()
    {
        Player player = new Player();
        List<Integer> numbers = player.getNumbers();
        assertEquals(3, numbers.size());
        assertTrue(numbers.stream().allMatch(i -> i >= 1 && i <= 9));
    }
}
