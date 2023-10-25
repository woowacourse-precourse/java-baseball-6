package baseball.controller;

import baseball.ExceptionMessage;
import baseball.SYSTEM_VALUE.GameStatusValue;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BallNumberVerifier implements InputVerifier {
    public static boolean hasDuplicateNumber(String input) {
        String[] strings = input.split("");
        Set<String> stringSet = new HashSet<>(Arrays.asList(strings));
        return stringSet.size() != input.length();
    }

    @Override
    public void verify(String input) {
        isNumeric(input);
//        isControlNumber(input);
        isThreeDigits(input);
        isDistinct(input);
    }


    private void isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMERIC);
        }
    }

    private void isThreeDigits(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_THREE_DIGITS);
        }
    }

    private void isControlNumber(String input) {
        int integerInput = Integer.parseInt(input);
        if (integerInput != GameStatusValue.GAME_RESTART && integerInput != GameStatusValue.GAME_EXIT) {
            throw new IllegalArgumentException(ExceptionMessage.UNKNOWN_CONTROL_INPUT);
        }
    }

    private void isDistinct(String input) {
        if (hasDuplicateNumber(input)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_DISTINCT);
        }
    }
}
