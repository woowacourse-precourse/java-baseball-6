package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StepResultTest {

    @Test
    void toStringTest() {
        int[][] testCases = {
                { 1, 2 },
                { 2, 0 },
                { 0, 0 },
                { 3, 0 },
                { 0, 3 },
                { 0, 2 }
        };
        String[] expected = {
                "1볼 2스트라이크",
                "2볼",
                "낫싱",
                "3볼",
                "3스트라이크",
                "2스트라이크"
        };

        int maxIdx = testCases.length;
        for (int i = 0; i < maxIdx; i++) {
            StepResult stepResult = new StepResult(testCases[i][0], testCases[i][1]);
            Assertions.assertEquals(expected[i], stepResult.toString());
        }
    }
}
