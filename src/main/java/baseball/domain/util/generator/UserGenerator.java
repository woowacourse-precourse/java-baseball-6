package baseball.domain.util.generator;

import baseball.domain.view.input.UserInput;
import java.util.ArrayList;
import java.util.List;

public class UserGenerator {
    private static final char ZERO_ASCII = '0';

    public static List<Integer> getAttempt() {
        List<Integer> result = new ArrayList<>();

        String userInput = UserInput.getGamingInput();

        // String -> List<Integer>
        for (char c : userInput.toCharArray()) {
            result.add(c - ZERO_ASCII);
        }

        return result;
    }
}
