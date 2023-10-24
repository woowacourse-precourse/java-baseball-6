package baseball;

import java.util.List;

public class Validators {
    private static final int ANSWER_LENGTH = 3;
    private static final int MINIMUM_DIGIT_RANGE = 1;
    private static final int MAXIMUM_DIGIT_RANGE = 9;
    static boolean isLengthValid;


    public static void validatePlayerInput(List<Character> playerInputList) {
        validateLength(playerInputList);
        validateRepetition(playerInputList);
        validateIsCharDigit(playerInputList);
    }

    private static void validateLength(List<Character> playerInputList) {
        if (!(playerInputList.size() == ANSWER_LENGTH)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateIsCharDigit(List<Character> playerInputList) {
        for (int i = 0; i < ANSWER_LENGTH; i++) {
            if (playerInputList.get(i) == '0' || !Character.isDigit(playerInputList.get(i))) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateRepetition(List<Character> playerInputList) {
        for (int i = 0; i < playerInputList.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (playerInputList.get(i) == playerInputList.get(j)) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }
}
