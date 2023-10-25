package baseball.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CounterTest {
    @Test
    @DisplayName("스트라이크 카운트 테스트")
    void countStrikeBallTest() {

        String guessNumOne = "456";
        String guessNumTwo = "789";
        String guessNumThree = "154";
        List<Integer> theAnswer = Arrays.asList(4, 5, 6);
        Counter counter = new Counter();

        assertEquals(3, counter.countStrikeBall(guessNumOne, theAnswer));
        assertEquals(0, counter.countStrikeBall(guessNumTwo, theAnswer));
        assertEquals(1, counter.countStrikeBall(guessNumThree, theAnswer));
    }
}