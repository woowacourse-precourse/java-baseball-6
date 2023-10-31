package baseball.domain.util.generator;

import baseball.domain.view.input.UserInput;
import java.util.ArrayList;
import java.util.List;

public class UserGenerator {
    public static List<Integer> getAttempt() {
        List<Integer> result = new ArrayList<>();

        String userInput = UserInput.getGamingInput();

        // String -> List<Integer>
        for (char c : userInput.toCharArray()) {
            result.add(c - '0');
        }

        return result;
    }
}
