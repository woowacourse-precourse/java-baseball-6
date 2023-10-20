package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CommonNumbersTest {

    @Test
    void checkWithSomeNumbers() {
        String[] testCases = {
                "164",
                "870",
                "514",
                "883"
        };
        int[] expected = {
                164,
                870,
                514,
                883
        };

        int i = 0;
        for (String testCase : testCases) {
            Numbers num = new CommonNumbers(testCase);
            int e = expected[i];
            assertEquals(e % 10, num.thirdNumber());
            assertEquals(e % 100 / 10, num.secondNumber());
            assertEquals(e / 100, num.firstNumber());
            List<Integer> l = num.allNumbers();
            assertEquals(e % 10, l.get(2));
            assertEquals(e % 100 / 10, l.get(1));
            assertEquals(e / 100, l.get(0));
            assertEquals(testCase, num.toString());
            i++;
        }
    }
}
