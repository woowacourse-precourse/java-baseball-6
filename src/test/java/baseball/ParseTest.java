package baseball;

import baseball.utils.ParseUserInput;
import org.junit.jupiter.api.Test;

public class ParseTest {
    @Test
    void testParse() {
        ParseUserInput parseUserInput = new ParseUserInput();
        String str = "113";

        int[] userNumbers = parseUserInput.getUserNumbers(str, 3);
        for (int i : userNumbers) {
            System.out.println(i);
        }
    }

}
