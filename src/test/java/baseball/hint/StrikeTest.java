package baseball.hint;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StrikeTest {
    @Test
    void 스트라이크_개수_확인() {
        Strike strike = new Strike();

        List<Integer> randomNumber = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> userNumber = new ArrayList<>(Arrays.asList(3, 2, 1));

        assertEquals(1, strike.compare(randomNumber, userNumber));
    }
}