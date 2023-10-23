package baseball.util;

import baseball.constant.Regex;
import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    public static boolean isValid(String input) {
        return matchesPattern(input) && hasNoDuplicateDigits(input);
    }

    private static boolean matchesPattern(String input) {
        return Regex.ONE_TO_NINE.matches(input);
    }

    private static boolean hasNoDuplicateDigits(String input) {
        Set<Character> uniqueDigits = new HashSet<>();
        for (char digit : input.toCharArray()) {
            uniqueDigits.add(digit);
        }
        return uniqueDigits.size() == input.length();
    }
}
