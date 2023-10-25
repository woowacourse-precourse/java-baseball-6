package baseball;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    private static final int ANSWER_INPUT_LENGTH = 3;
    private static final int RESTART_INPUT_LENGTH = 1;
    private static final char INVALID_INPUT_CHAR = '0';
    private static final List<String> restartValues = List.of("1", "2");

    private Validator() {
        throw new UnsupportedOperationException();
    }

    public static void validateAnswerInput(String answerInput) {

        if (invalidInputLength(ANSWER_INPUT_LENGTH, answerInput)) {
            throw new IllegalArgumentException();
        }

        List<Character> checkDuplicateList = new ArrayList<>();

        for (char input : answerInput.toCharArray()) {
            if (!Character.isDigit(input)) {
                throw new IllegalArgumentException();
            }
            if (input == INVALID_INPUT_CHAR) {
                throw new IllegalArgumentException();
            }
            if (checkDuplicateList.contains(input)) {
                throw new IllegalArgumentException();
            }
            checkDuplicateList.add(input);
        }
    }

    public static void validateRestartInput(String restartInput) {
        if (invalidInputLength(RESTART_INPUT_LENGTH, restartInput)) {
            throw new IllegalArgumentException();
        }
        if (!restartValues.contains(restartInput)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean invalidInputLength(int length, String input) {
        return input.length() != length;
    }
}
