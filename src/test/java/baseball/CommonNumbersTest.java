package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

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
            Assertions.assertEquals(e % 10, num.thirdNumber());
            Assertions.assertEquals(e % 100 / 10, num.secondNumber());
            Assertions.assertEquals(e / 100, num.firstNumber());
            List<Integer> l = num.allNumbers();
            Assertions.assertEquals(e % 10, l.get(2));
            Assertions.assertEquals(e % 100 / 10, l.get(1));
            Assertions.assertEquals(e / 100, l.get(0));
            Assertions.assertEquals(testCase, num.toString());
            i++;
        }
    }
}
