package baseball.utils;

import baseball.constants.ErrorMessage;
import baseball.constants.Regex;

public class Validator {
    public static String validateBaseballInput(String userGuess) {
        if (!isValidThreeDigitNumber(userGuess)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ENOUGH_LENGTH);
        }

        if (!hasNoRepeatedDigits(userGuess)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED);
        }

        return userGuess;
    }

    private static boolean isValidThreeDigitNumber(String userGuess) {
        return Regex.NUMBER_REGEX.matcher(userGuess).matches();
    }

    private static boolean hasNoRepeatedDigits(String userGuess) {
        long userGuessUniqueLength = userGuess.chars().distinct().count();

        return userGuessUniqueLength == userGuess.split("").length;
    }

    public static void validateRestartOption(String userInput) {
        int input = Integer.parseInt(userInput);

        if (input != 1 && input != 2) {
            throw new IllegalArgumentException(ErrorMessage.NOT_RESTART_OPTION);
        }
    }
}
