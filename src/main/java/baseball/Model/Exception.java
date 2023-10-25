package baseball.Model;

import java.util.HashSet;
import java.util.Set;

public class Exception {
    public static boolean isNumber(String userInput) {
        return userInput.chars()
                .allMatch(Character::isDigit);
    }

    public static boolean hasDuplicates(String userInput) {
        return userInput.chars()
                .distinct()
                .count() != userInput.length();
    }

    public static boolean isValidLength(String userInput) {
        return userInput.length() == GameConstant.MAX_NUM;
    }

    public static boolean containsZero(String userInput) {
        return userInput.contains("0");
    }
}
