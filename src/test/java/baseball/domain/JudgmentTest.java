package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class JudgmentTest {

    @Test
    void 숫자_카운트() {
        Judgment judgment = new Judgment();
        int count = judgment.correctCount(Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 1));

        assertEquals(3, count);
    }

    @Test
    void 해당_자리에_같은_숫_카운트() {
        Judgment judgment = new Judgment();
        boolean hasPlace = judgment.hasPlace(Arrays.asList(1, 2, 3), 0, 1);

        assertTrue(hasPlace);
    }
    
}
