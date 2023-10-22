package baseball;

import java.util.HashSet;
import java.util.Set;

public class UserInputValidation {
    private static final Integer GAME_NUMBER_SIZE = 3;
    private static final Integer RESTART_NUMBER_SIZE = 1;

    public boolean isValidGameNumber(String userInput) {
        if (!isValidLengthGameNumber(userInput)) {
            return false;
        }
        if (!isRangeGameNumber(userInput)) {
            return false;
        }
        return !isDuplicateGameNumber(userInput);
    }

    private boolean isValidLengthGameNumber(String userInput) {
        return userInput.length() == GAME_NUMBER_SIZE;
    }

    private boolean isValidLengthRestartNumber(String userInput) {
        return userInput.length() == RESTART_NUMBER_SIZE;
    }


    public boolean isValidRestartNumber(String userInput) {
        if (!isValidLengthRestartNumber(userInput)) {
            return false;
        }
        return isRangeRestartNumber(userInput);
    }

    private boolean isRangeGameNumber(String userInput) {
        for (int i = 0; i < GAME_NUMBER_SIZE; ++i) {
            char c = userInput.charAt(i);
            int number = Character.getNumericValue(c);
            if (number < 1 || number > 9) {
                return false;
            }
        }
        return true;
    }

    private boolean isDuplicateGameNumber(String userInput) {
        Set<Character> numberSet = new HashSet<>();
        for (char c : userInput.toCharArray()) {
            if (!numberSet.add(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean isRangeRestartNumber(String userInput) {
        char c = userInput.charAt(0);
        int number = Character.getNumericValue(c);
        return number >= 0 && number <= 2;
    }
}
