package baseball;

import java.util.List;

public class Validators {
    private static final int ANSWER_LENGTH = 3;
    private static final int MINIMUM_DIGIT_RANGE = 1;
    private static final int MAXIMUM_DIGIT_RANGE = 9;
    static boolean isLengthValid;


    public static void validatePlayerInput(List<Character> playerInputList) {
        if (!(validateLength(playerInputList) && validateIsCharDigit(playerInputList))) {
            throw new IllegalArgumentException("Error");
        }
    }

    private static boolean validateLength(List<Character> playerInputList) {
        if (playerInputList.size() == ANSWER_LENGTH) {
            isLengthValid = true;
        }
        return isLengthValid;
    }

    public static boolean validateIsCharDigit(List<Character> playerInputList) {
        for (int i = 0; i < ANSWER_LENGTH; i++) {
            if (!Character.isDigit(playerInputList.get(i))) {
                return false;
            }
        }
        return true;
    }
}
