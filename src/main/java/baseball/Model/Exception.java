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
        if (userInput.length() != GameConstant.MAX_NUM) {
            return false;
        }
        return true;
    }

    public static boolean checkIsZero(String userInput) {
        if (userInput.contains("0")) {
            return true;
        }
        return false;
    }
}
