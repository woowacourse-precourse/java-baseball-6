package baseball;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    private static final int ANSWER_INPUT_LENGTH = 3;
    private static final int RESTART_INPUT_LENGTH = 1;
    private static final char INVALID_INPUT_CHAR = '0';
    private static final List<String> restartValues = List.of("1", "2");
    private static ArrayList<Character> checkDuplicateList;

    public static void validateAnswerInput(String answerInput) {

        if (!validInputLength(ANSWER_INPUT_LENGTH, answerInput)) {
            throw new IllegalArgumentException();
        }

        checkDuplicateList = new ArrayList<>();

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
        if (!validInputLength(RESTART_INPUT_LENGTH, restartInput)) {
            throw new IllegalArgumentException();
        }
        if (!restartValues.contains(restartInput)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean validInputLength(int length, String input) {
        if (input.length() == length) {
            return true;
        }
        return false;
    }
}
