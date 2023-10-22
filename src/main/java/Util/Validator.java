package Util;

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
    }

    public static void validateInputLength(String userInput, int expectedLength) {
        if (userInput.length() != expectedLength) {
            throw new IllegalArgumentException(expectedLength + "개의 숫자를 입력하세요.");
        }
    }

    public static void validateMenuChoice(String choice) {
        if (!choice.equals(Message.RETRYGAME.getMessage()) && !choice.equals(Message.ENDGAME.getMessage())) {
            throw new IllegalArgumentException("1 또는 2를 입력하세요.");
        }
    }

    private static boolean isValidNumberInput(String input) {
        if (!NUMBER_PATTERN.matcher(input).matches()) {
            return false;
        }

        Set<Character> seen = new HashSet<>();

        for (char digit : input.toCharArray()) {
            if (!seen.add(digit)) {
                return false;
            }
        }
        return true;
    }

}