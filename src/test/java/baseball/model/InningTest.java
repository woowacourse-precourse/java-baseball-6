package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InningTest {
    private Inning inning;

    @BeforeEach
    public void setUp() {
        ArrayList<Integer> answer = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(2, 1, 4));
        inning = new Inning(answer, input);
    }

    @Test
    public void testCalculateResult() {
        String result = inning.calculateResult();
        assertEquals("2볼", result);
    }

}
