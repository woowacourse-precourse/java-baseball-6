package Util;

import Model.BaseballNumberConstants;
import View.RetryView.Message;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Validator {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("[1-9]+");

    public static void validateUserInput(String userInput) {
        if (!isValidNumberInput(userInput)) {
            throw new IllegalArgumentException("1에서 9 사이의 숫자를 입력하세요.");
        }
        if (!isDuplicationNumberInput(userInput)) {
            throw new IllegalArgumentException("중복된 숫자를 입력하지마세요.");
        }
        if (!validateInputLength(userInput)) {
            throw new IllegalArgumentException(BaseballNumberConstants.INPUT_MAX + "개의 숫자를 입력하세요.");
        }
    }

    private static boolean validateInputLength(String userInput) {
        if (userInput.length() != BaseballNumberConstants.INPUT_MAX_COUNTS) {
            return false;
        }
        return true;
    }

    private static boolean isValidNumberInput(String input) {
        if (!NUMBER_PATTERN.matcher(input).matches()) {
            return false;
        }
        return true;
    }

    private static boolean isDuplicationNumberInput(String input) {
        Set<Character> seen = new HashSet<>();

        for (char digit : input.toCharArray()) {
            if (!seen.add(digit)) {
                return false;
            }
        }
        return true;
    }

    public static void validateRetryNumberChoice(String choice) {
        if (!choice.equals(Message.RETRYGAME.getMessage()) && !choice.equals(
                Message.ENDGAME.getMessage())) {
            throw new IllegalArgumentException("1 또는 2를 입력하세요.");
        }
    }
}
