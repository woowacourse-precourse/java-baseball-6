package baseball.validate;

import java.util.Set;
import java.util.stream.Collectors;

public class CheckInput {
    private static final int INPUT_LENGTH = 3;

    public static void validatePlayerInput(String userInput) {
        checkLength(userInput);
        checkInteger(userInput);
        checkHasZero(userInput);
        checkDuplicate(userInput);
    }

    private static void checkLength(String userInput) {
        if (userInput.length() != INPUT_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkInteger(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (IllegalArgumentException error) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkHasZero(String userInput) {
        if (userInput.contains("0")) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkDuplicate(String userInput) {
        Set<Character> characterSet = userInput.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toSet());
        if (characterSet.size() != INPUT_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
