package baseball.Model;

import java.util.HashSet;
import java.util.Set;

public class Exception {
    public static boolean checkIsNumber(String userInput) {
        return userInput.chars()
                .allMatch(Character::isDigit);
    }

    public static boolean checkIsDuplicated(String userInput) {
        return userInput.chars()
                .distinct()
                .count() != userInput.length();
    }

    public static boolean checkInputLength(String userInput) {
        return userInput.length() == GameConstant.MAX_NUM;
    }

    public static boolean checkIsZero(String userInput) {
        return userInput.contains("0");
    }
}
