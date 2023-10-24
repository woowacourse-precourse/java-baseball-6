package baseball.utils;

import baseball.constants.Constants;
import baseball.constants.Messages;

public class Validator {
    public static void validateUserInput(String userInput) throws IllegalArgumentException {
        if (isNull(userInput) || !meetsLengthCondition(userInput, Constants.ANS_LEN) ||
                !meetsRangeCondition(userInput, '1', '9') || containsDuplicateNum(userInput)) {
            throw new IllegalArgumentException(Messages.ERROR_MESSAGE);
        }
    }

    public static void validateRestartInput(String userInput) throws IllegalArgumentException {
        if (isNull(userInput) || !meetsLengthCondition(userInput, Constants.RESTART_LEN) ||
                !meetsRangeCondition(userInput, '1', '2')) {
            throw new IllegalArgumentException(Messages.ERROR_MESSAGE);
        }
    }

    private static boolean isNull(String userInput) {
        return userInput == null;
    }

    private static boolean meetsLengthCondition(String userInput, int lengthLimit) {
        return userInput.length() == lengthLimit;
    }

    private static boolean meetsRangeCondition(String userInput, char start, char end) {
        for (char ch : userInput.toCharArray()) {
            if (!(start <= ch && ch <= end)) {
                return false;
            }
        }
        return true;
    }

    private static boolean containsDuplicateNum(String userInput) {
        int[] count = new int[10];
        for (char ch : userInput.toCharArray()) {
            int curCnt = ++count[ch - '0'];
            if (curCnt > 1) {
                return true;
            }
        }
        return false;
    }
}
