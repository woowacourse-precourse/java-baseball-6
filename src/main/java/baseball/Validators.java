package baseball;

import java.util.List;

public class Validators {
    private static final int ANSWER_LENGTH = 3;
    private static final int MINIMUM_DIGIT_RANGE = 1;
    private static final int MAXIMUM_DIGIT_RANGE = 9;
    boolean isLengthValid;
    boolean isDigit;
//    public boolean validatePlayerInput() {
//
//    }

    private boolean validateLength(List<Integer> playerInput) {
        if (playerInput.size() == ANSWER_LENGTH) {
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
