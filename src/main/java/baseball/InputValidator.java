package baseball;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    public static void validateInputAnswer(String inputAnswer) {
        if (inputAnswer.length() != Computer.NUMBER_DIGIT) {
            throw new IllegalArgumentException();
        }

        Set<Character> tempSet = new HashSet<>();

        for (Character ch : inputAnswer.toCharArray()) {
            if (!Character.isDigit(ch) || !tempSet.add(ch)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateRetryInput(String retryInput) {
        if (!retryInput.equals(Player.RETRY_COMMAND) && !retryInput.equals(Player.END_COMMAND)) {
            throw new IllegalArgumentException();
        }
    }
}
