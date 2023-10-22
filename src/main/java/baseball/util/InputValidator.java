package baseball.util;

import baseball.constant.ExceptionMessage;
import baseball.constant.GameConstants;
import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    public void validate(String input) {
        is3DigitsNumber(input);
        isConsistsOfUniqueDigits(input);
    }

    private void is3DigitsNumber(String input) {
        if (input.length() != GameConstants.MAX_VALUE) {
            throw new IllegalArgumentException(ExceptionMessage.Requires3Digits.getMessage());
        }

        for (int i = 0; i < input.length(); i++) {
            if (!input.matches(GameConstants.ONLY_NUMBER_REGEX)) {
                throw new IllegalArgumentException(ExceptionMessage.RequiresOnlyNumberBetween1And9.getMessage());
            }
        }
    }

    private void isConsistsOfUniqueDigits(String input) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            set.add(input.charAt(i));
        }

        if (set.size() != input.length()) {
            throw new IllegalArgumentException(ExceptionMessage.RequiresUniqueElements.getMessage());
        }
    }
}