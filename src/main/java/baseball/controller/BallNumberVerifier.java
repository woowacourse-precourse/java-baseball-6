package baseball.controller;

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
    public void verify(String input) throws IllegalArgumentException {
        isNumeric(input);
        isThreeDigits(input);
        isDistinct(input);
    }

    private void isThreeDigits(String input) throws IllegalArgumentException {
        if (input.length() != 3) {
            throw new IllegalArgumentException("세 자리 숫자가 아닙니다.");
        }
    }

    private void isNumeric(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private void isDistinct(String input) throws IllegalArgumentException {
        if (hasDuplicateNumber(input)) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }
}
