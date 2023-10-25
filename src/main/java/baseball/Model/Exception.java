package baseball.Model;

import java.util.HashSet;
import java.util.Set;

public class Exception {
    public static boolean checkIsNumber(String userInput) {
        return userInput.chars()
                .allMatch(Character::isDigit);
    }

    public static boolean checkIsDuplicated(String userInput) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < userInput.length(); i++) {
            if (!set.add(userInput.charAt(i))) {
                return true;
            }
        }
        return false;
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
