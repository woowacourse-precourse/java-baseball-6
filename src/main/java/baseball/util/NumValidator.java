package baseball.util;

import baseball.view.GameView;

public class NumValidator {
    public static void isValid(String num) {
        checkLength(num);
        checkRange(num);
        checkDuplicates(num);
    }

    private static void checkLength(String num) {
        if (num.length() != GameConfig.GAME_NUM_SIZE.getValue()) {
            GameView.displayErrorMessage(Messages.LENGTH_ERROR_MESSAGE);
            throw new IllegalArgumentException(Messages.LENGTH_ERROR_MESSAGE);
        }
    }

    private static void checkRange(String num) {
        for (char digit : num.toCharArray()) {
            int value = Character.getNumericValue(digit);
            if (value < GameConfig.RANDOM_MIN_VALUE.getValue() || value > GameConfig.RANDOM_MAX_VALUE.getValue()) {
                GameView.displayErrorMessage(Messages.RANGE_ERROR_MESSAGE);
                throw new IllegalArgumentException(Messages.RANGE_ERROR_MESSAGE);
            }
        }
    }

    private static void checkDuplicates(String num) {
        for (int i = 0; i < num.length(); i++) {
            char digit = num.charAt(i);
            for (int j = i + 1; j < num.length(); j++) {
                if (digit == num.charAt(j)) {
                    GameView.displayErrorMessage(Messages.DUPLICATE_ERROR_MESSAGE);
                    throw new IllegalArgumentException(Messages.DUPLICATE_ERROR_MESSAGE);
                }
            }
        }
    }
}
